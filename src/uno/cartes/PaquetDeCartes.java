package uno.cartes;
import java.io.*;
import java.util.*;

import uno.errorHandler.ErreurFichier;

/**
 * @author Clément Oberhauser
 * @version TP5 - BPO
 */

public class PaquetDeCartes implements Iterable<Carte>{
  private ArrayList<Carte> cartePaquet;

  /**
   * Retourne vrai si le paquet est vide
   * @return [boolean]
   */
  public boolean estVide(){
    return this.cartePaquet.isEmpty();
  }

  /**
   * Contructeur par recopie d'un paquet de carte
   * @param nbCarte  [ArrayList contenant les uno.cartes]
   */
  public PaquetDeCartes(ArrayList<Carte> nbCarte){
    assert(nbCarte != null): "L'ArrayList nbCarte dans le contructeur PaquetDeCartes: Erreur !";
    this.cartePaquet = nbCarte;
  }

  /**
   * Contructeur sans paramètre de PaquetDeCartes
   */
  public PaquetDeCartes(){
    ArrayList<Carte> nbCarte = new ArrayList<>(5);
    this.cartePaquet = nbCarte;
  }

  /**
   * Ajoute des uno.cartes dans le paquet actuel
   * @param cartesToAdd  [Cartes à ajouter au paquet]
   */
  public void ajouter(Carte ... cartesToAdd){
    assert(cartesToAdd != null): "La collection de carte est à null dans la fct ajouter de PaquetDeCartes: Erreur !";
    // assert(cartesToAdd.size() == this.cartePaquet.size()): "La taille de  dans la fct ajouter de PaquetDeCartes: Erreur !";
    this.cartePaquet.addAll(Arrays.asList(cartesToAdd));
  }

  public void clearPaquet(){
    this.cartePaquet.removeAll(this.cartePaquet);
  }

  /**
   * Inverse la position des uno.cartes dans le paquet
   * abcd -> dcba
   */
  public void retourner(){
    assert(!this.estVide()): "Impossible d'inverser la liste, la collection est vide, fct retourner PaquetDeCartes";
    Collections.reverse(this.cartePaquet);
  }

  /**
   * Mélange le paquet aléatoirement
   */
  public void melanger(){
    assert(!this.estVide()): "Impossible de mélanger la liste, la collection est vide, fct mélanger PaquetDeCartes";
    Collections.shuffle(this.cartePaquet);
  }

  /**
   * Ajoute un PaquetDeCartes au paquet actuel
   * @param cartesToAdd  [variable PaquetDeCartes]
   */
  public void ajouter(PaquetDeCartes cartesToAdd){
    assert(cartesToAdd != null): "La collection de carte est à null dans la fct ajouter de PaquetDeCartes: Erreur !";
    // assert(cartesToAdd.size() == this.cartePaquet.size()): "La taille de  dans la fct ajouter de PaquetDeCartes: Erreur !";
    this.cartePaquet.addAll(cartesToAdd.cartePaquet);
  }

  /**
   * Retourne la taille du paquet de uno.cartes
   * @return [Int taille du paquet]
   */
  public int getNombreDeCartes(){
    return this.cartePaquet.size();
  }

  /**
   * Retourne la carte qui est au sommet du paquet de uno.cartes
   * @return [Carte]
   */
  public Carte getSommet(){
    assert(this.estVide() != true): "Impossible de retourner le sommet la liste, la collection est vide, fct getSommet PaquetDeCartes";
    return this.cartePaquet.get(this.getNombreDeCartes()-1);
  }

  /**
   * Enlève une carte contenue dans le paquet de carte,
   * affiche une erreur si elle n'y est pas trouvée
   * @param carteToRemove  [Carte présente dans le paquet à enlever]
   */
  public Carte enlever(Carte carteToRemove){
    assert(carteToRemove != null): "La carte a enlever vaut null, impossible de la supprimer | fct enlever, PaquetDeCartes";
    assert(this.cartePaquet.lastIndexOf(carteToRemove) != -1): "La carte ne semble pas présente dans le paquet ! fct enlever, PaquetDeCartes";
    assert(this.estVide() != true): "Impossible d'enlever une carte de la liste, la collection est vide, fct enlever PaquetDeCartes";
    return this.cartePaquet.remove(this.cartePaquet.lastIndexOf(carteToRemove));
  }

  /**
   * Retourne une carte piochée aléatoirement dans le paquet
   * @return [Carte du paquet]
   */
  public Carte piocher(){
    Integer rand = (int)(Math.random() * this.getNombreDeCartes() + 1);
    if (rand == this.getNombreDeCartes()) {
      rand--;
    }
    // System.out.println(rand);
    assert(rand != 0 || this.cartePaquet.size() != 0): "Le paquet de carte est vide, on ne peut pas piocher dedans (cl PaquetDeCartes / piocher)";
    return enlever(this.cartePaquet.get(rand));
    //return paretourner;
  }

  public Carte getCarte(int index){
    return this.cartePaquet.get(index);
  }


  /**
   * Retourne une carte piochée aléatoirement dans le paquet
   * @param nomDeFichier Nom courant du fichier sur lequel écrire
   */
  public void ecrire(String nomDeFichier) throws ErreurFichier{
    File fichier = new File(nomDeFichier);

    if (!fichier.exists()){
      throw new ErreurFichier("Le fichier n'existe pas impossible d'écrire dessus");
    }

    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(nomDeFichier));
      for (Carte c : this.cartePaquet) {
        writer.write(c.getName() + c.getValeur() + " " + c.getCouleur() + "\n");
      }
      writer.close();
    }catch (IOException e){
      System.out.println("Impossible de créer le FileWriter et d'écrire dans le fichier");
      e.printStackTrace();
    }
  }

  public PaquetDeCartes lire(String nomDeFichier) throws ErreurFichier{
    Uno u1 = new Uno();
    //String path = "testLoop.txt";
    int nb = 0;
    //int[] tabOccur = new int[26];
    //for (int j = 0; j < tabOccur.length; j++)
    //  tabOccur[j] = 0;
    try{
      if (!new File(nomDeFichier).exists()){
        throw new ErreurFichier("Le fichier n'existe pas impossible de le lire");
      }
      BufferedReader filtre = new BufferedReader(new FileReader(nomDeFichier));
      StreamTokenizer tk = new StreamTokenizer(filtre);
      tk.eolIsSignificant(true);
      int ligne = tk.nextToken();
      this.cartePaquet.clear();
      while (ligne != StreamTokenizer.TT_EOF){
        if (ligne == StreamTokenizer.TT_WORD){
          char c = tk.sval.charAt(tk.sval.length() - 1);
          if (Character.isDigit(tk.sval.charAt(tk.sval.length() - 1))){
            String s1;
            int valeur = 0;
            Couleur coultoAdd;

            if (tk.sval.charAt(tk.sval.length() - 1) == '0'){
              if (Character.isDigit(tk.sval.charAt(tk.sval.length() - 2))){
                s1 = tk.sval.substring(0, tk.sval.length() - 2);
              }else{
                s1 = tk.sval.substring(0, tk.sval.length() - 1);
              }
            }else{
              s1 = tk.sval.substring(0, tk.sval.length() - 1);
            }

            valeur = (int)tk.sval.charAt(tk.sval.length() - 1) - '0';


            ligne = tk.nextToken();

            switch (tk.sval){
              case "VERT":
                coultoAdd = Couleur.VERT;
                break;
              case "ROUGE":
                coultoAdd = Couleur.ROUGE;
                break;
              case "BLEU":
                coultoAdd = Couleur.BLEU;
                break;
              case "JAUNE":
                coultoAdd = Couleur.JAUNE;
                break;
              default:
                throw new ErreurFichier("Impossible de récupérer la Couleur d'une carte du fichier");
            }

            //System.out.println(s1);

            switch (s1){
              case "Chiffre":
                this.cartePaquet.add(new Chiffre(u1, coultoAdd, valeur));
                break;

              case "PlusDeux":
                this.cartePaquet.add(new Plus2(u1, coultoAdd));
                break;

              case "PlusQuatre":
                this.cartePaquet.add(new Plus4(u1, coultoAdd));
                break;

              case "ChangementDeSens":
                this.cartePaquet.add(new ChangementDeSens(u1, coultoAdd));
                break;

              case "PasseTonTour":
                this.cartePaquet.add(new PasseTonTour(u1, coultoAdd));
                break;

              case "Joker":
                this.cartePaquet.add(new Joker(u1, coultoAdd));
                break;

              default:
                throw new ErreurFichier("La carte lue dans le fichier ne correspond a aucune carte pouvant être créée");
            }
          }else{
            throw new ErreurFichier("Il n'y a pas de valeur (Number) dans le premier mot de la ligne ");
          }
          //System.out.println("Carte : " + tk.sval);
          //ligne = tk.nextToken();
          //System.out.println("Couleur : " + tk.sval);
        }
        ligne = tk.nextToken();
      }


    }catch(IOException e){
      System.out.println("Erreur : dans la lecture des caractères");
      e.printStackTrace();
    }
    return null;
  }

  /**
   * String permettant d'afficher le contenu du paquet de carte
   * @return [String] Paquet de carte sous forme d'une chaine de caractère
   */
  public String toString(){
    String toReturn;

    toReturn = "Paquet de carte : [";

    for (Carte c : this.cartePaquet) {
      toReturn = toReturn + System.getProperty("line.separator") + c + ",";
    }

    toReturn = toReturn + System.getProperty("line.separator") + " ] fin du Paquet ";

    return toReturn;
  }

  @Override
  public Iterator<Carte> iterator() {
    return this.cartePaquet.iterator();
  }
}
