package cartes;
import cartes.Uno;

public abstract class Carte {

    private Uno uno;
    private Couleur couleur ;

    /**
     * Contructeur de carte
     * @param uno Jeu uno
     * @param couleur  Couleur de la carte
     */
    public Carte(Uno uno, Couleur couleur) {
      assert(uno != null):"Uno dans le constructeur Carte(Uno uno, Couleur couleur) est NULL";
      assert(couleur != null):"Couleur dans le constructeur Carte(Uno uno, Couleur couleur) est NULL";
      this.uno = uno;
      this.couleur = couleur;
    }

    /**
     * Constructeur par recopie de Carte
     * @param u Jeu à copier
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
    public abstract Integer getValeur();

    /**
     * Vrai si la couleur peut etre rcouverte
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
     * Retourne un String pour afficher les attributs de la carte
     * @return String du contenu 
     */
/*    public String toString() {
        return "Carte{" +
                "valeur=" + valeur +
                ", couleur=" + couleur +
                '}';
    }
*/
}
