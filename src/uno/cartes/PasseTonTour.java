package uno.cartes;

/**
 * Carte spéciale du jeu de Uno, permet de passer le tour du joueur suivant
 */
public class PasseTonTour extends Carte{

    /**
     * Constructeur de la classe PasseTonTour
     * @param u Uno, jeu courant
     * @param c couleur à ajouter à la carte
     */
    public PasseTonTour(Uno u, Couleur c){
        super(u, c);
    }

    /**
     * @return La valeur de la carte PasseTonTour (20)
     */
    @Override
    public int getValeur() {
        return 20;
    }

    @Override
    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public boolean peutEtrePoseeSur(Chiffre c) {
        return this.getCouleur() == c.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(Plus2 c) {
        return this.getCouleur() == c.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(Plus4 c) {
        return this.getCouleur() == c.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(Joker c) {
        return this.getCouleur() == c.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return this.getCouleur() == c.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return this.getCouleur() == c.getCouleur();
    }

    /**
     * @return le nom de la Carte ici: "PasseTonTour"
     */
    @Override
    public String getName(){
        return "PasseTonTour";
    }

    /**
     * Change le joueur Actuel du uno pour passer au suivant (+1 si le sens est horaire, -1 si antihoraire
     */
    public void appliquerEffet(){
        if (this.uno.getSens() == 1){
            this.uno.setJoueurActuel(this.uno.getJoueurActuel() + 1);
            if (this.uno.getJoueurActuel() == this.uno.getNbJoueur())
                this.uno.setJoueurActuel(0);
        }else{
            this.uno.setJoueurActuel(this.uno.getJoueurActuel() - 1);
            if (this.uno.getJoueurActuel() < 0)
                this.uno.setJoueurActuel(this.uno.getNbJoueur() - 1);
        }
    }
}
