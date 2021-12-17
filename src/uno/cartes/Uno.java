package uno.cartes;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import uno.dialogues.DialogueUno;
import uno.errorHandler.ErreurUno;
import uno.joueurs.Bots;
import uno.joueurs.Humain;
import uno.joueurs.Joueur;

public class Uno {
    private int sens;
    private int joueurActuel;
    private int nbJoueur;
    //private boolean etatJeu;
    private Joueur[] tabJoueur;
    private PaquetDeCartes talon;
    private PaquetDeCartes pioche;
    private DialogueUno diagUno;

    public Uno() {
    }

    public void initialiser(int nbJoueurL, String nomJoueur) throws ErreurUno{
        //Scanner sc = new Scanner(System.in);
        //int limiteEntree = 0;
        //System.out.println("Entrez le nombre de bots avec qui vous voulez jouer");
        /*do {
            try{
                this.nbJoueur = sc.nextInt();
            }catch(InputMismatchException i){
                initialiser(nbJoueurL);
            }

            limiteEntree++;

            if (limiteEntree >= 15)
                throw new ErreurUno("Impossible de créer le jeu, le nombre de joueur est n'est pas compris entre 2 et 7");
            if (this.nbJoueur < 2 || this.nbJoueur > 7)
                System.out.println(this.nbJoueur + " n'est pas compris entre 1 et 7, réessayez");

        }while (this.nbJoueur < 2 || this.nbJoueur > 7);*/

        creerLesJoueur(nbJoueurL, nomJoueur);
        distribuerCarte();
        choisirQuiJoue();
        this.diagUno.reagir();
    }

    public void creerLesJoueur(int nbJoueurL, String nomJoueur){
        this.nbJoueur = nbJoueurL;
        this.tabJoueur = new Joueur[nbJoueurL];

        //Scanner sc = new Scanner(System.in);
        //String nomJoueur = sc.nextLine();
        //System.out.println("Entrez votre nom de joueur");
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

    public void distribuerCarte() throws ErreurUno{
        if (this.tabJoueur == null)
            throw new ErreurUno("Impossible de distribuer les uno.cartes, le tableau contenant les uno.joueurs est à null");

        this.pioche = FabriqueCartes.getInstance().getPaquetComplet();
        this.pioche.melanger();
        this.talon = new PaquetDeCartes();
        this.talon.ajouter(this.pioche.piocher());

        for (int i = 0; i < this.nbJoueur; i++){
            for (int j = 0; j < 7; j++){
                this.tabJoueur[i].getPaquetJoueur().ajouter(this.pioche.piocher());
            }
        }

        //this.tabJoueur[0].getPaquetJoueur().ajouter(this.pioche.piocher());
        //System.out.println(this.pioche.piocher());
    }

    public void choisirQuiJoue(){
        this.joueurActuel = (int)(Math.random() * 4);
        this.sens = 1;
    }

    public void setDialogue(DialogueUno diagPara){
        this.diagUno = diagPara;
    }

    public int getNbCarteEnMainJoueur(){
        return this.tabJoueur[0].getPaquetJoueur().getNombreDeCartes();
    }

    public boolean estUnJoueurHumain(){
        return this.tabJoueur[this.joueurActuel].joueurEstHumain();
    }

    public void jouer(char coupAjouer){
        if (coupAjouer == '*') {
            //this.tabJoueur[joueurActuel].jouer();
        }else{
            this.tabJoueur[joueurActuel].jouer(coupAjouer);
        }
    }

    /**
     * GETTER & SETTER
     */

    public int getSens() {
        return sens;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }

    public int getJoueurActuel() {
        return joueurActuel;
    }

    public void setJoueurActuel(int joueurActuel) {
        this.joueurActuel = joueurActuel;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public Joueur[] getTabJoueur() {
        return tabJoueur;
    }

    public void setTabJoueur(Joueur[] tabJoueur) {
        this.tabJoueur = tabJoueur;
    }

    public PaquetDeCartes getTalon() {
        return talon;
    }

    public void setTalon(PaquetDeCartes talon) {
        this.talon = talon;
    }

    public PaquetDeCartes getPioche() {
        return pioche;
    }

    public void setPioche(PaquetDeCartes pioche) {
        this.pioche = pioche;
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
