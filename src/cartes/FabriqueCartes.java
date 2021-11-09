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
    this.paquet.ajouter(new Carte(6, Couleur.VERT));
    return this.paquet;
  }

  public PaquetDeCartes getPaquet5Vert(){
    this.paquet.ajouter(new Carte(9, Couleur.VERT), new Carte(6, Couleur.VERT), new Carte(3, Couleur.VERT), new Carte(12, Couleur.VERT), new Carte(15, Couleur.VERT));
    return this.paquet;
  }
}
