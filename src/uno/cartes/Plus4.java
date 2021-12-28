package uno.cartes;

public class Plus4 extends Carte{
    public Plus4(Uno u, Couleur c){
        super(u, c);
    }
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
        return this.getCouleur() == c.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(PasseTonTour c) {
        return true;
    }

    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return true;
    }

    @Override
    public String getName(){
        return "PlusQuatre";
    }

    public void appliquerEffet(){
        int joueurQuiRecoit = this.uno.getJoueurActuel();

        if (this.uno.getSens() == 1){
            joueurQuiRecoit++;
            if (joueurQuiRecoit == this.uno.getNbJoueur())
                joueurQuiRecoit = 0;
            if (this.uno.getTabJoueur()[joueurQuiRecoit].getPaquetJoueur().getNombreDeCartes() < 0){
                do {
                    joueurQuiRecoit++;
                    if (joueurQuiRecoit == this.uno.getNbJoueur())
                        joueurQuiRecoit = 0;
                } while (this.uno.getTabJoueur()[joueurQuiRecoit].getPaquetJoueur().getNombreDeCartes() < 0);
            }

        }else{
            joueurQuiRecoit--;
            if (joueurQuiRecoit < 0)
                joueurQuiRecoit = this.uno.getNbJoueur() - 1;
            if (this.uno.getTabJoueur()[joueurQuiRecoit].getPaquetJoueur().getNombreDeCartes() < 0){
                do {
                    joueurQuiRecoit--;
                    if (joueurQuiRecoit < 0)
                        joueurQuiRecoit = this.uno.getNbJoueur() - 1;
                } while (this.uno.getTabJoueur()[joueurQuiRecoit].getPaquetJoueur().getNombreDeCartes() < 0);
            }
        }

        if (!(joueurQuiRecoit == this.uno.getJoueurActuel())) {
            for (int i = 0; i < 4; i++) {
                this.uno.getTabJoueur()[joueurQuiRecoit].getPaquetJoueur().ajouter(this.uno.getPioche().piocher());
            }
        }

        //Permet de ne pas laisser jouer le joueur qui a reçu le +4
        // Dans ce cas, si il n'y a que deux personnes en jeu le joueur qui joue cette carte rejoue..
        //this.uno.setJoueurActuel(joueurQuiRecoit);
    }
}
