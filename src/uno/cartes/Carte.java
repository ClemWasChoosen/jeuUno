package uno.cartes;

/**
 * Représentation abstraire des cartes du jeu pour les redéfinir.
 */
public abstract class Carte {

    protected Uno uno;
    protected Couleur couleur;

    /**
     * Contructeur de carte
     * @param uno uno.jeu uno
     * @param couleur  Couleur de la carte
     */
    public Carte(Uno uno, Couleur couleur) {
      assert(uno != null):"Uno dans le constructeur Carte(Uno uno, Couleur couleur) est NULL";
      //assert(couleur != null):"Couleur dans le constructeur Carte(Uno uno, Couleur couleur) est NULL";
      this.uno = uno;
      this.couleur = couleur;
    }

    /**
     * Constructeur par recopie de Carte
     * @param u uno.jeu à copier
     */
    public Carte(Uno u) {
      assert(u != null):"Uno dans le constructeur Carte(Uno uno, Couleur couleur) est NULL";
      this.uno = u;
      this.couleur = null;
    }

    /**
     * Retourne le numéro de la carte
     * @return valeur de la carte
     */
    public abstract int getValeur();

    /**
     * Vrai si la couleur peut etre recouverte
     * @param c Carte recouvrant celle sur le paquet
     */
    public abstract boolean peutEtreRecouvertePar(Carte c);

    /**
     * Retourne la couleur de la Carte
     * @return Couleur de la carte
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Définie la couleur de la Carte
     * @param couleur  Couleur à ajouter
     */
    public void setCouleur(Couleur couleur) {
      assert(couleur != null): "Parametre couleur dans setCouleur est à null: Erreur!";
        this.couleur = couleur;
    }

    /**
     * Vérifie la carte possède une couleur
     * @return true si la couleur == null sinon retourne vrai
     */
    public boolean estSansCouleur(){
        return this.couleur == null;
    }

    /**
     * Vérifie si la carte a la même couleur que celle en paramètre
     * @param c Carte vérifiant la compatibilité
     * @return Vrai si la couleur est la même que celle en paramètre
     */
    public boolean estDeCouleurCompatibleAvec(Carte c){
        return this.couleur == c.couleur;
    }


    /**
     * Vérifie si la carte peut être posée sur la Carte c
     * @param c Carte accueillant la carte du jeu
     * @return Vrai si la carte peut être posée sur la carte en paramètre
     */
    public abstract boolean peutEtrePoseeSur(Chiffre c);

    /**
     * Vérifie si la carte peut être posée sur la Carte c
     * @param c Carte accueillant la carte du jeu
     * @return Vrai si la carte peut être posée sur la carte en paramètre
     */
    public abstract boolean peutEtrePoseeSur(Plus2 c);

    /**
     * Vérifie si la carte peut être posée sur la Carte c
     * @param c Carte accueillant la carte du jeu
     * @return Vrai si la carte peut être posée sur la carte en paramètre
     */
    public abstract boolean peutEtrePoseeSur(Plus4 c);

    /**
     * Vérifie si la carte peut être posée sur la Carte c
     * @param c Carte accueillant la carte du jeu
     * @return Vrai si la carte peut être posée sur la carte en paramètre
     */
    public abstract boolean peutEtrePoseeSur(Joker c);

    /**
     * Vérifie si la carte peut être posée sur la Carte c
     * @param c Carte accueillant la carte du jeu
     * @return Vrai si la carte peut être posée sur la carte en paramètre
     */
    public abstract boolean peutEtrePoseeSur(PasseTonTour c);

    /**
     * Vérifie si la carte peut être posée sur la Carte c
     * @param c Carte accueillant la carte du jeu
     * @return Vrai si la carte peut être posée sur la carte en paramètre
     */
    public abstract boolean peutEtrePoseeSur(ChangementDeSens c);

    /**
     * Retourne un String pour afficher les attributs de la carte
     * @return Nom de la carte
     */
    public abstract String getName();

    /**
     * Applique l'effet d'une carte sur le jeu
     * Cette fonction ne fait rien dans le cas général, on la redéfinit dans les fonctions nécessaires
     */
    public void appliquerEffet(){}

    /**
     * Retourne un String pour afficher les attributs de la carte
     * @return String du contenu 
     */
    public String toString() {
        return this.getName() + "(" +
                "couleur=" + couleur +
                ')';
    }

}
