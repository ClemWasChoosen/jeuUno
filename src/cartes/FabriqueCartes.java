package cartes;

import cartes.*;
import errorHandler.ErreurUno;

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

  public PaquetDeCartes getPaquet1Vert() throws ErreurUno {
    Uno u1 = new Uno();
    this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, 5));
    return this.paquet;
  }

  public PaquetDeCartes getPaquet5Vert() throws ErreurUno {
    Uno u1 = new Uno();
    this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, 3), new Plus2(u1, Couleur.VERT), new Chiffre(u1, Couleur.VERT, 7), new Chiffre(u1, Couleur.VERT, 9), new Chiffre(u1, Couleur.VERT, 2));
    return this.paquet;
  }

  public PaquetDeCartes getPaquetComplet() throws ErreurUno {
    Uno u1 = new Uno();
    for (int j = 0; j < 2; j++)
        for (int i = 1; i < 10; i++) {
          this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, i));
          this.paquet.ajouter(new Chiffre(u1, Couleur.JAUNE, i));
          this.paquet.ajouter(new Chiffre(u1, Couleur.BLEU, i));
          this.paquet.ajouter(new Chiffre(u1, Couleur.ROUGE, i));
      }

    this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, 0));
    this.paquet.ajouter(new Chiffre(u1, Couleur.JAUNE, 0));
    this.paquet.ajouter(new Chiffre(u1, Couleur.BLEU, 0));
    this.paquet.ajouter(new Chiffre(u1, Couleur.ROUGE, 0));

    for (int i = 0; i < 2; i++) {
      this.paquet.ajouter(new Plus2(u1, Couleur.VERT));
      this.paquet.ajouter(new Plus2(u1, Couleur.BLEU));
      this.paquet.ajouter(new Plus2(u1, Couleur.ROUGE));
      this.paquet.ajouter(new Plus2(u1, Couleur.JAUNE));

      this.paquet.ajouter(new PasseTonTour(u1, Couleur.VERT));
      this.paquet.ajouter(new PasseTonTour(u1, Couleur.BLEU));
      this.paquet.ajouter(new PasseTonTour(u1, Couleur.ROUGE));
      this.paquet.ajouter(new PasseTonTour(u1, Couleur.JAUNE));

      this.paquet.ajouter(new ChangementDeSens(u1, Couleur.VERT));
      this.paquet.ajouter(new ChangementDeSens(u1, Couleur.BLEU));
      this.paquet.ajouter(new ChangementDeSens(u1, Couleur.ROUGE));
      this.paquet.ajouter(new ChangementDeSens(u1, Couleur.JAUNE));

    }

    for (int i = 0; i < 3; i++){
      this.paquet.ajouter(new Joker(u1, null));
      this.paquet.ajouter(new Plus4(u1, null));
    }

    return this.paquet;

  }

  @Override
  public String toString() {
    return "FabriqueCartes{" +
            paquet +
            '}';
  }
}
