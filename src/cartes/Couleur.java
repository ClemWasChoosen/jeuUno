package cartes;


public enum Couleur{
  BLEU("bleu"),
  ROUGE("rouge"),
  VERT("vert"),
  JAUNE("jaune");

  private String nom;

  private Couleur(String nom){
    assert(nom != null): "Nom est à null dans le constructeur Couleur: erreur !";
    this.nom = nom;
  }

  public String getNom(){
    return this.nom;
  }

}
