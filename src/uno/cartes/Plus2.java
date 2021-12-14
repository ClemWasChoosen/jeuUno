package uno.cartes;

public class Plus2 extends Carte{

    public Plus2(Uno u, Couleur c){
        super(u, c);
    }

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
        return true;
    }

    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return this.getCouleur() == this.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return false;
    }

    @Override
    public String getName(){
        return "PlusDeux";
    }
}
