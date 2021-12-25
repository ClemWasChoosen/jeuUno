package uno.cartes;

public class PasseTonTour extends Carte{
    public PasseTonTour(Uno u, Couleur c){
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
    /**TODO
     * Couleur de Joker peut être à null
     */
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
    public String getName(){
        return "PasseTonTour";
    }

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
        System.out.println("Joueur actuel : " + this.uno.getJoueurActuel());
    }
}
