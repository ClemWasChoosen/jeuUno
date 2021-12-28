package uno.cartes;

/**
 * Singleton d'un PaquetDeCarte, permet principalement de retourner le talon car retourne un paquet complet
 * déjà instancié. Dans les autres cas, retourne des paquets pour les tests
 */
public class FabriqueCartes {
  private static FabriqueCartes instance = new FabriqueCartes();

  /**
   * @return l'instance = l'initialisation du paquet de carte
   */
  public static FabriqueCartes getInstance(){
    return instance;
  }

  private PaquetDeCartes paquet;

  /**
   * Constructeur de FabriqueCarte qui va initialiser le paquet pour la classe, inutilisée en dehors
   */
  private FabriqueCartes(){
    PaquetDeCartes p1 = new PaquetDeCartes();
    this.paquet = p1;
  }

  public PaquetDeCartes getPaquet(){
    return this.paquet;
  }

  /**
   * @return le paquet contenant une carte verte de valeur 5 (Uno initialisé vide)
   */
  public PaquetDeCartes getPaquet1Vert(){
    Uno u1 = new Uno();
    this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, 5));
    return this.paquet;
  }

  /**
   * @return le paquet contenant 5 cartes vertes (Uno initialisé à vide)
   */
  public PaquetDeCartes getPaquet5Vert(){
    Uno u1 = new Uno();
    this.paquet.ajouter(new Chiffre(u1, Couleur.VERT, 3), new Plus2(u1, Couleur.VERT), new Chiffre(u1, Couleur.VERT, 7), new Chiffre(u1, Couleur.VERT, 9), new Chiffre(u1, Couleur.VERT, 2));
    return this.paquet;
  }

  /**
   * Permet de retourner une pioche complète d'un jeu de uno avec les 108 cartes et Uno est passé en paramètre
   * @param uno Uno, jeu actuel
   * @return le paquet contenant un jeu complet
   */
  public PaquetDeCartes getPaquetComplet(Uno uno) {
    //Uno u1 = new Uno();
    for (int j = 0; j < 2; j++)
        for (int i = 1; i < 10; i++) {
          this.paquet.ajouter(new Chiffre(uno, Couleur.VERT, i));
          this.paquet.ajouter(new Chiffre(uno, Couleur.JAUNE, i));
          this.paquet.ajouter(new Chiffre(uno, Couleur.BLEU, i));
          this.paquet.ajouter(new Chiffre(uno, Couleur.ROUGE, i));
      }

    this.paquet.ajouter(new Chiffre(uno, Couleur.VERT, 0));
    this.paquet.ajouter(new Chiffre(uno, Couleur.JAUNE, 0));
    this.paquet.ajouter(new Chiffre(uno, Couleur.BLEU, 0));
    this.paquet.ajouter(new Chiffre(uno, Couleur.ROUGE, 0));

    for (int i = 0; i < 2; i++) {
      this.paquet.ajouter(new Plus2(uno, Couleur.VERT));
      this.paquet.ajouter(new Plus2(uno, Couleur.BLEU));
      this.paquet.ajouter(new Plus2(uno, Couleur.ROUGE));
      this.paquet.ajouter(new Plus2(uno, Couleur.JAUNE));

      this.paquet.ajouter(new PasseTonTour(uno, Couleur.VERT));
      this.paquet.ajouter(new PasseTonTour(uno, Couleur.BLEU));
      this.paquet.ajouter(new PasseTonTour(uno, Couleur.ROUGE));
      this.paquet.ajouter(new PasseTonTour(uno, Couleur.JAUNE));

      this.paquet.ajouter(new ChangementDeSens(uno, Couleur.VERT));
      this.paquet.ajouter(new ChangementDeSens(uno, Couleur.BLEU));
      this.paquet.ajouter(new ChangementDeSens(uno, Couleur.ROUGE));
      this.paquet.ajouter(new ChangementDeSens(uno, Couleur.JAUNE));
    }

    for (int i = 0; i < 4; i++){
      this.paquet.ajouter(new Joker(uno, null));
      this.paquet.ajouter(new Plus4(uno, null));
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
