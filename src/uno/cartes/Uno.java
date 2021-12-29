package uno.cartes;

import java.util.Arrays;

import uno.dialogues.DialogueUno;
import uno.errorHandler.CoupIncorrect;
import uno.errorHandler.ErreurUno;
import uno.joueurs.Bots;
import uno.joueurs.Humain;
import uno.joueurs.Joueur;

/**
 * Classe comprenant le jeu, tous les paramètres propres au bon déroulement d'un jeu de Uno y est
 */
public class Uno {
    private int sens;
    private int joueurActuel;
    private int nbJoueur;
    private boolean etatJeu;
    private Joueur[] tabJoueur;
    private PaquetDeCartes talon;
    private PaquetDeCartes pioche;
    private DialogueUno diagUno;

    /**
     * Constructeur vide de la classe Uno (utilisez initialiser() pour créer un nouveau jeu)
     */
    public Uno() {
    }

    /**
     * Permet de créer toutes les instances nécessaire au jeu
     *      créer les joueurs, distribue les cartes, choisit le joueur qui joue
     *      et enfin lance le jeu
     * @param nbJoueurL nombre de joueur jouant au jeu
     * @param nomJoueur nom du joueur principal (seul joueur non bot)
     * @throws ErreurUno toutes les erreurs liées au développement d'un jeu de Uno
     */
    public void initialiser(int nbJoueurL, String nomJoueur) throws ErreurUno{
        this.etatJeu = false;
        creerLesJoueurs(nbJoueurL, nomJoueur);
        distribuerCarte();
        choisirQuiJoue();
        this.diagUno.reagir();
    }

    /**
     * Ajoute les joueurs au jeu, leur donne un nom, assigne des paquets à chacun
     * @param nbJoueurL nombre de joueurs total dans le jeu (avec le joueur humain)
     * @param nomJoueur nom du joueur humain
     */
    public void creerLesJoueurs(int nbJoueurL, String nomJoueur){
        this.nbJoueur = nbJoueurL;
        this.tabJoueur = new Joueur[nbJoueurL];

        this.tabJoueur[0] = new Humain(nomJoueur);
        this.tabJoueur[0].getPaquetJoueur().clearPaquet();

        for (int i = 1; i < nbJoueurL; i++){
            String nomBot;
            if (i == 1)
                nomBot = i + "erBots";
            else
                nomBot = i + "emeBots";

            this.tabJoueur[i] = new Bots(nomBot);
            this.tabJoueur[i].getPaquetJoueur().clearPaquet();
        }
    }

    /**
     * Créer la pioche et la mélange, créer le talon avec une carte de la pioche, Distribue les cartes au joueur, aux bots
     * @throws ErreurUno
     */
    public void distribuerCarte() throws ErreurUno{
        if (this.tabJoueur == null)
            throw new ErreurUno("Impossible de distribuer les uno.cartes, le tableau contenant les uno.joueurs est à null");

        this.pioche = FabriqueCartes.getInstance().getPaquetComplet(this);
        this.pioche.melanger();
        this.talon = new PaquetDeCartes();
        this.talon.ajouter(this.pioche.piocher());

        for (int i = 0; i < this.nbJoueur; i++){
            for (int j = 0; j < 7; j++){
                this.tabJoueur[i].getPaquetJoueur().ajouter(this.pioche.piocher());
            }
        }
    }

    /**
     * Choisi le joueur actuel aléatoirement et fixe le sens à 1 (sens horaire = 1, sens antihoraire = 0)
     */
    public void choisirQuiJoue(){
        this.joueurActuel = (int)(Math.random() * this.nbJoueur);
        this.sens = 1;
    }

    /**
     * fixe le dialogue en paramètre
     * @param diagPara dialogue qui va remplacer celui en attrivut
     */
    public void setDialogue(DialogueUno diagPara){
        assert(diagPara != null):"Le paramètre est null, impossible de l'ajouter à l'attribut de Uno";
        this.diagUno = diagPara;
    }

    /**
     * @return le nombre de carte qu'a le joueur dans sa main
     */
    public int getNbCarteEnMainJoueur(){
        return this.tabJoueur[0].getPaquetJoueur().getNombreDeCartes();
    }

    /**
     * @return vrai si le joueur est humain false sinon
     */
    public boolean estUnJoueurHumain(){
        return this.tabJoueur[this.joueurActuel].joueurEstHumain();
    }

    /**
     * Permet de jouer une carte présente dans le paquet d'un joueur, cette fonction fait appel aux fonctions dans la classe Joueur
     * On passe au joueur suivant à la fin de la fonction puis on appelle reagir() de la classe DialogueUno
     * @param coupAjouer contient le coup à jouer, si le premier caractère est "*", on joue automatiquement.
     */
    public void jouer(String coupAjouer){
        if (coupAjouer.charAt(0) != '*'  && this.joueurActuel == 0) {
            if (this.tabJoueur[0].getPaquetJoueur().getNombreDeCartes() > 0)
                try{
                    this.tabJoueur[0].jouer(coupAjouer, this.talon, this.pioche, this.diagUno);
                }catch(CoupIncorrect c){
                    c.printStackTrace();
                    this.diagUno.reagir();
                }
        }else{
            this.tabJoueur[joueurActuel].jouer(this.talon, this.pioche);
        }
        if (getPaquetJoueurActuel().getNombreDeCartes() <= 0){
            this.etatJeu = true;
        }

        if (this.etatJeu){
        }else if (this.sens == 1){
            this.joueurActuel++;
            if (this.joueurActuel == this.nbJoueur)
                this.joueurActuel = 0;
        }else{
            this.joueurActuel--;
            if (this.joueurActuel < 0)
                this.joueurActuel = this.nbJoueur - 1;
        }

        if (this.pioche.getNombreDeCartes() <= 10){
            for (int i = 0; i < this.talon.getNombreDeCartes() - 2; i++)
                this.pioche.ajouter(this.talon.enlever(this.talon.getCarte(i)));
            this.pioche.retourner();
        }

        this.diagUno.reagir();
    }

    /**
     * @return le paquet du joueur actuel pour l'afficher à l'écran dans DialogueUno
     */
    public String toStringPaquet(){
        String res = "";

        for (int i = 0; i < getPaquetJoueurActuel().getNombreDeCartes(); i++){
            res = res + " (" + (i+1) + ")e carte: " + this.getPaquetJoueurActuel().getCarte(i);
            if ((i + 1)%3 == 0)
                res = res + "\n";
        }
        res = res + "#";
        return res;
    }

    /*
     * GETTER & SETTER
     */

    /**
     * @return paquet du joueur actuel
     */
    public PaquetDeCartes getPaquetJoueurActuel(){
        return this.tabJoueur[this.joueurActuel].getPaquetJoueur();
    }

    /**
     * @return le sens actuel du jeu
     */
    public int getSens() {
        return sens;
    }

    /**
     * @param sens paramètre qui fixe le sens du jeu
     */
    public void setSens(int sens) {
        this.sens = sens;
    }

    /**
     * @return le joueur actuel
     */
    public int getJoueurActuel() {
        return joueurActuel;
    }

    /**
     * @param joueurActuel paramètre qui fixe le joueur actuel
     */
    public void setJoueurActuel(int joueurActuel) {
        this.joueurActuel = joueurActuel;
    }

    /**
     * @return le nombre de joueurs dans le jeu
     */
    public int getNbJoueur() {
        return nbJoueur;
    }

    /**
     * @return le tableau contenant tous les joueurs
     */
    public Joueur[] getTabJoueur() {
        return tabJoueur;
    }

    /**
     * @return le talon du jeu de Uno
     */
    public PaquetDeCartes getTalon() {
        return talon;
    }

    /**
     * @param talon paramètre qui fixe le talon du jeu de Uno
     */
    public void setTalon(PaquetDeCartes talon) {
        this.talon = talon;
    }

    /**
     * @return la pioche du jeu de Uno
     */
    public PaquetDeCartes getPioche() {
        return pioche;
    }

    /**
     * @param pioche paramètre qui fixe la pioche du jeu de Uno
     */
    public void setPioche(PaquetDeCartes pioche) {
        this.pioche = pioche;
    }

    /**
     * @return l'état actuel du jeu (false si le jeu tourne, true si il y a un gagnant)
     */
    public boolean getEtatJeu(){
        return this.etatJeu;
    }

    @Override
    public String toString() {
        return "Uno{" +
                "sens=" + sens +
                ", joueurActuel=" + joueurActuel +
                ", nbJoueur=" + nbJoueur +
                ", tabJoueur=" + Arrays.toString(tabJoueur) +
                ", talon=" + talon +
                ", pioche=" + pioche +
                '}';
    }
}
