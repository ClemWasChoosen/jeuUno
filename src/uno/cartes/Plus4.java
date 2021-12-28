package uno.cartes;

/**
 * Carte spéciale du jeu de Uno, permet d'ajouter 4 cartes au paquet du joueur suivant et de choisir la couleur
 */
public class Plus4 extends Carte{
    /**
     * Constructeur de Plus4
     * @param u uno, jeu actuel
     * @param c couleur de la carte (null lors de la déclaration,
     *          la couleur est choisie par le joueur ensuite)
     */
    public Plus4(Uno u, Couleur c){
        super(u, c);
    }

    /**
     * @return La valeur de la carte Plus4 (50)
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

    /**
     * @return le nom de la Carte ici: "PlusQuatre"
     */
    @Override
    public String getName(){
        return "PlusQuatre";
    }

    /**
     * Ajoute 4 cartes au joueur suivant (en fonction du sens actuel du jeu)
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
            for (int i = 0; i < 4; i++) {
                this.uno.getTabJoueur()[joueurQuiRecoit].getPaquetJoueur().ajouter(this.uno.getPioche().piocher());
            }
        }

        //Permet de ne pas laisser jouer le joueur qui a reçu le +4
        // Dans ce cas, si il n'y a que deux personnes en jeu le joueur qui joue cette carte rejoue..
        //this.uno.setJoueurActuel(joueurQuiRecoit);
    }
}
