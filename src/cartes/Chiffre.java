package cartes;

import cartes.Carte;
import cartes.Couleur;
import cartes.Uno;

public class Chiffre extends Carte {
    protected int val;

    public Chiffre(Uno u, Couleur c, int val){
        super(u, c);
        this.val = val;
    }

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
        return true;
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
        return "Chiffre{" +
                "val=" + val + ", couleur=" + this.getCouleur() +
                '}';
    }

    @Override
    public String getName(){
        return "Chiffre";
    }
}
