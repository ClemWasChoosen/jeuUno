package uno.cartes;

/**
 * Carte à poser permettant de changer de sens dans le jeu
 */
public class ChangementDeSens extends Carte{
    /**
     * Constructeur de ChangementDeSens
     * @param u Uno, jeu actuel
     * @param c Couleur à donner à la carte
     */
    public ChangementDeSens(Uno u, Couleur c){
        super(u, c);
    }

    /**
     * @return La valeur de la carte ChangementDeSens (20)
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
     * @return le nom de la Carte ici: "ChangementDeSens"
     */
    @Override
    public String getName(){
        return "ChangementDeSens";
    }

    /**
     * Change le sens du jeu, 0 si le sens est à 1 et inversement
     */
    public void appliquerEffet(){
        if (this.uno != null){
            if (this.uno.getSens() != 0)
                this.uno.setSens(0);
            else
                this.uno.setSens(1);
        }
    }
}
