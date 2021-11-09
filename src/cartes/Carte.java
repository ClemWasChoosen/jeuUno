package cartes;

public class Carte {

    private Integer valeur ;
    private Couleur couleur ;

    /**
     * Contructeur de carte
     * @param valeur   numéro de la cartes
     * @param couleur  Couleur de la carte
     */
    public Carte(Integer valeur, Couleur couleur) {
      assert(valeur != null): "Valeur dans le constructeur cartes est à null: Erreur!";
      assert(valeur != null): "Valeur dans le constructeur cartes est à null: Erreur!";
      this.valeur = valeur;
      this.couleur = couleur;
    }

    /**
     * Constructeur par recopie de Carte
     * @param c  Carte déjà existante
     */
    public Carte(Carte c) {
      assert(c != null): "Carte dans le constructeur de recopie cartes est à null: Erreur!";
      this.valeur = c.valeur;
      this.couleur = c.couleur;
    }

    /**
     * Retourne le numéro de la carte
     * @return valeur de la carte
     */
    public Integer getValeur() {
        return valeur;
    }

    /**
     * Définie la valeur de la carte
     * @param valeur  Integer à ajouter à la carte
     */
    public void setValeur(Integer valeur) {
      assert(valeur != null): "Parametre Valeur dans setValeur est à null: Erreur!";
      this.valeur = valeur;
    }

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
    public String toString() {
        return "Carte{" +
                "valeur=" + valeur +
                ", couleur=" + couleur +
                '}';
    }

}
