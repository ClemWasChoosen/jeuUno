package uno.cartes;

/**
 * Un Joker est une carte du jeu de Uno spéciale. Elle permet de poser une carte peu importe la carte sur le talon
 * et elle permet de choisir la couleur qui va être joué
 */
public class Joker extends Carte {
    /**
     * Constructeur de Joker
     * @param u Uno, jeu actuel
     * @param c Couleur à donner à la carte
     */
    public Joker(Uno u, Couleur c){
        super(u, c);
    }

    /**
     * @return La valeur de la carte Joker (50)
     */
    @Override
    public int getValeur() {
        return 50;
    }

    @Override
    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public boolean peutEtrePoseeSur(Chiffre c) {
        return true;
    }

    @Override
    public boolean peutEtrePoseeSur(Plus2 c) {
        return true;
    }

    @Override
    public boolean peutEtrePoseeSur(Plus4 c) {
        return true;
    }

    @Override
    public boolean peutEtrePoseeSur(Joker c) {
        return true;
    }

    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return true;
    }

    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return true;
    }

    /**
     * @return le nom de la Carte ici: "Joker"
     */
    @Override
    public String getName(){
        return "Joker";
    }
}
