package cartes;

import cartes.*;

public class FabriqueCartes {
  private static FabriqueCartes instance = new FabriqueCartes();

  public static FabriqueCartes getInstance(){
    return instance;
  }

  private PaquetDeCartes paquet;

  private FabriqueCartes(){
    PaquetDeCartes p1 = new PaquetDeCartes();
    this.paquet = p1;
  }

  public PaquetDeCartes getPaquet(){
    return this.paquet;
  }

  public PaquetDeCartes getPaquet1Vert(){
    Uno u1 = new Uno();
    this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, 5));
    return this.paquet;
  }

  public PaquetDeCartes getPaquet5Vert(){
    Uno u1 = new Uno();
    this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, 3), new Plus2(u1, Couleur.VERT), new Chiffre(u1, Couleur.VERT, 7), new Chiffre(u1, Couleur.VERT, 9), new Chiffre(u1, Couleur.VERT, 2));
    return this.paquet;
  }

  @Override
  public String toString() {
    return "FabriqueCartes{" +
            paquet +
            '}';
  }
}
