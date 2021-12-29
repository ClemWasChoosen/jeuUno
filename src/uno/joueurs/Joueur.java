package uno.joueurs;

import uno.cartes.*;
import uno.dialogues.DialogueUno;
import uno.errorHandler.CoupIncorrect;

/**
 * Classe abstraire des joueurs du jeu de Uno
 */
public abstract class Joueur {
    protected String nom;
    protected PaquetDeCartes paquetJoueur;
    //A ajouter si nécessaire
    //protected int rang

    /**
     * Constructeur de Joueur
     * @param nom nom du joueur
     */
    public Joueur(String nom){
        this.nom = nom;
        this.paquetJoueur = new PaquetDeCartes();
    }

    /**
     * @return le paquet de carte du joueur
     */
    public PaquetDeCartes getPaquetJoueur(){
        return this.paquetJoueur;
    }

    public String getNom(){
        return this.nom;
    }

    /**
     * Retourne un String du joueur
     * @return joueur + nom du joueur + paquet du joueur
     */
    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", paquetJoueur=" + paquetJoueur +
                '}';
    }

    /**
     * Fonction redéfinie dans les sous classes
     * @param coupAJouer coup que le joueur veut jouer
     * @param talon talon du jeu de Uno actuel
     * @return la carte choisie par le joueur
     * @throws CoupIncorrect
     */
    public abstract Carte carteChoisie(String coupAJouer, Carte talon) throws CoupIncorrect;

    /**
     * Joue automatiquement une carte du Joueur
     * parcourt toutes cartes du paquet et sélectionne la première possible
     * @param talon talon du jeu de Uno
     * @param pioche pioche du jeu de Uno
     */
    public void jouer(PaquetDeCartes talon, PaquetDeCartes pioche){
        Carte cartEnlevee = null;
        if (this.paquetJoueur.getNombreDeCartes() > 0){
            for (int i = 0; i < this.paquetJoueur.getNombreDeCartes(); i++){
                if (talon.getSommet().peutEtreRecouvertePar(this.paquetJoueur.getCarte(i))){
                    cartEnlevee = this.paquetJoueur.enlever(this.paquetJoueur.getCarte(i));
                    cartEnlevee.appliquerEffet();
                    break;
                }
            }
        }

        if (cartEnlevee != null){
            if (cartEnlevee.getCouleur() == null)
                cartEnlevee.setCouleur(getRandColor());
            talon.ajouter(cartEnlevee);
        }else if(this.paquetJoueur.getNombreDeCartes() > 0){
            this.paquetJoueur.ajouter(pioche.piocher());
        }
    }

    /**
     * Récupère aléatoirement une couleur et la retourne
     * @return une couleur
     */
    public Couleur getRandColor(){
        int rand = (int)(Math.random() * 4);
        Couleur coul;
        switch (rand){
            case 0:
                coul = Couleur.ROUGE;
                break;
            case 1:
                coul = Couleur.BLEU;
                break;
            case 2:
                coul = Couleur.VERT;
                break;
            default:
                coul = Couleur.JAUNE;
                break;
        }

        return coul;
    }

    /**
     * Joue une carte du jeu en laissant à l'humain le choix de cette dernière
     * @param coupAJouer carte que le joueur veut jouer
     * @param talon talon du jeu de Uno
     * @param pioche pioche du jeu de Uno
     * @param diag dialogueUno pour demander à l'utilisateur la couleur de la carte si besoin
     * @throws CoupIncorrect la carte n'est pas jouable
     */
    public abstract void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche, DialogueUno diag) throws CoupIncorrect;

    /**
     * @return si le joueur est un humain ou non
     */
    public abstract boolean joueurEstHumain();

    /**
     * Demande au joueur de choisir une couleur pour sa carte
     * @param carteAChanger carte avec la couleur null
     * @param diag dialogueUno pour demander à l'utilisateur la couleur de la carte si besoin
     * @throws CoupIncorrect
     */
    public abstract void choisirCouleurCarte(Carte carteAChanger, DialogueUno diag) throws CoupIncorrect;
}
