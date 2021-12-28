package uno.cartes;

/**
 * Carte la plus basique du jeu Chiffre, contient une valeur et une couleur
 */
public class Chiffre extends Carte {
    protected int val;

    /**
     * Constructeur de la carte Chiffre
     * @param u uno, jeu actuel
     * @param c Couleur à donner à la carte
     * @param val valeur à donner à la carte
     */
    public Chiffre(Uno u, Couleur c, int val){
        super(u, c);
        this.val = val;
    }

    /**
     * @return La valeur de la carte, retourne donc le montant de Chiffre (vaut 8 si le carte est 8 rouge par ex)
     */
    public int getValeur(){
        return this.val;
    }

    @Override
    public boolean peutEtreRecouvertePar(Carte c) {
        return c.peutEtrePoseeSur(this);
    }

    @Override
    public boolean peutEtrePoseeSur(Chiffre c) {
        return c.getCouleur() == this.getCouleur() || c.getValeur() == this.getValeur();
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

    @Override
    public String toString() {
        return "Chiffre(" +
                "val=" + val + ", couleur=" + this.getCouleur() +
                ')';
    }

    /**
     * @return le nom de la Carte ici: "Chiffre"
     */
    @Override
    public String getName(){
        return "Chiffre";
    }
}
