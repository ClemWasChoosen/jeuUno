package cartes;

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
        return false;
    }

    @Override
    public boolean peutEtrePoseeSur(Carte c) {
        return false;
    }

    @Override
    public boolean peutEtrePoseeSur(Chiffre c) {
        return false;
    }

    @Override
    public boolean peutEtrePoseeSur(Plus2 c) {
        return false;
    }

    @Override
    public boolean peutEtrePoseeSur(Plus4 c) {
        return false;
    }

    @Override
    public boolean peutEtrePoseeSur(Joker c) {
        return false;
    }

    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return false;
    }

    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return false;
    }
}
