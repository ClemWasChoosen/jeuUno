package uno.cartes;


/**
 * Couleur d'une carte sous forme d'énumérateur, ne peut que être ROUGE/VERT/BLEU/JAUNE
 */
public enum Couleur{
  BLEU("bleu"),
  ROUGE("rouge"),
  VERT("vert"),
  JAUNE("jaune");

  private String nom;

  /**
   * Constructeur privé d'une Couleur
   * @param nom Couleur rouge/vert/bleu/jaune
   */
  private Couleur(String nom){
    assert(nom != null): "Nom est à null dans le constructeur Couleur: erreur !";
    this.nom = nom;
  }

  /**
   * @return nom de la couleur (rouge/vert/bleu/jaune)
   */
  public String getNom(){
    return this.nom;
  }

}
