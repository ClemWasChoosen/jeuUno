package uno.cartes;

/**
 * Carte spéciale du jeu de Uno, permet d'ajouter 2 cartes au paquet du joueur suivant
 */
public class Plus2 extends Carte{

    /**
     * Constructeur de la classe Plus2
     * @param u Uno, jeu actuel
     * @param c couleur du Plus2
     */
    public Plus2(Uno u, Couleur c){
        super(u, c);
    }

    /**
     * @return La valeur de la carte Plus2 (20)
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
        return this.getCouleur() == this.getCouleur();
    }

    @Override
    public boolean peutEtrePoseeSur(ChangementDeSens c) {
        return false;
    }

    /**
     * @return le nom de la Carte ici: "PlusDeux"
     */
    @Override
    public String getName(){
        return "PlusDeux";
    }

    /**
     * Ajoute 2 cartes au joueur suivant (en fonction du sens actuel du jeu)
     * Le joueur ayant reçu les 2 cartes peut tout de même jouer
     */
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
            for (int i = 0; i < 2; i++) {
                this.uno.getTabJoueur()[joueurQuiRecoit].getPaquetJoueur().ajouter(this.uno.getPioche().piocher());
            }
        }

        //Permet de ne pas laisser jouer le joueur qui a reçu le +2
        // Dans ce cas, si il n'y a que deux personnes en jeu le joueur qui joue cette carte rejoue..
        //this.uno.setJoueurActuel(joueurQuiRecoit);
    }
}
