package cartes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
import java.util.Random;

import cartes.Couleur;
import cartes.Carte;
import errorHandler.ErreurFichier;

/**
 * @author Clément Oberhauser
 * @version TP5 - BPO
 */

public class PaquetDeCartes {
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
   * @param nbCarte  [ArrayList contenant les cartes]
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
   * Ajoute des cartes dans le paquet actuel
   * @param cartesToAdd  [Cartes à ajouter au paquet]
   */
  public void ajouter(Carte ... cartesToAdd){
    assert(cartesToAdd != null): "La collection de carte est à null dans la fct ajouter de PaquetDeCartes: Erreur !";
    // assert(cartesToAdd.size() == this.cartePaquet.size()): "La taille de  dans la fct ajouter de PaquetDeCartes: Erreur !";
    for (Carte c : cartesToAdd) {
      this.cartePaquet.add(c);
    }
  }

  /**
   * Inverse la position des cartes dans le paquet
   * abcd -> dcba
   */
  public void retourner(){
    assert(this.estVide() != true): "Impossible d'inverser la liste, la collection est vide, fct retourner PaquetDeCartes";
    Collections.reverse(this.cartePaquet);
  }

  /**
   * Mélange le paquet aléatoirement
   */
  public void melanger(){
    assert(this.estVide() != true): "Impossible de mélanger la liste, la collection est vide, fct mélanger PaquetDeCartes";
    Collections.shuffle(this.cartePaquet);
  }

  /**
   * Ajoute un PaquetDeCartes au paquet actuel
   * @param cartesToAdd  [variable PaquetDeCartes]
   */
  public void ajouter(PaquetDeCartes cartesToAdd){
    assert(cartesToAdd != null): "La collection de carte est à null dans la fct ajouter de PaquetDeCartes: Erreur !";
    // assert(cartesToAdd.size() == this.cartePaquet.size()): "La taille de  dans la fct ajouter de PaquetDeCartes: Erreur !";
    for (Carte c : cartesToAdd.cartePaquet) {
      this.cartePaquet.add(c);
    }
  }

  /**
   * Retourne la taille du paquet de cartes
   * @return [Int taille du paquet]
   */
  public int getNombreDeCartes(){
    return this.cartePaquet.size();
  }

  /**
   * Retourne la carte qui est au sommet du paquet de cartes
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
  public void enlever(Carte carteToRemove){
    assert(carteToRemove != null): "La carte a enlever vaut null, impossible de la supprimer | fct enlever, PaquetDeCartes";
    assert(this.cartePaquet.lastIndexOf(carteToRemove) != -1): "La carte ne semble pas présente dans le paquet ! fct enlever, PaquetDeCartes";
    assert(this.estVide() != true): "Impossible d'enlever une carte de la liste, la collection est vide, fct enlever PaquetDeCartes";
    this.cartePaquet.remove(this.cartePaquet.lastIndexOf(carteToRemove));
  }

  /**
   * Retourne une carte piochée aléatoirement dans le paquet
   * @return [Carte du paquet]
   */
 /* public Carte piocher(){
    Integer rand = (int)(Math.random() * this.getNombreDeCartes() + 1);
    if (rand == this.getNombreDeCartes()) {
      rand--;
    }
    // System.out.println(rand);
    assert(rand != 0 || this.cartePaquet.size() != 0): "Le paquet de carte est vide, on ne peut pas piocher dedans (cl PaquetDeCartes / piocher)";
    Carte paretourner = new Carte(this.cartePaquet.get(rand));
    enlever(this.cartePaquet.get(rand));
    return paretourner;
  }
*/
  void ecrire(String nomDeFichier) throws ErreurFichier{
    File fichier = new File(nomDeFichier);
  //  int resnbLine = nbLine.nextInt((30 - 10) + 1) + 10;

    if (!fichier.exists()){
      throw new ErreurFichier("Le fichier n'existe pas impossible d'écrire dessus");
    }

    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(nomDeFichier));
      for (int i = 0; i <= this.cartePaquet.size(); i++){
        writer.write(this.cartePaquet.get(i).toString() + this.cartePaquet.get(i).getValeur() + " " + this.cartePaquet.get(i).getCouleur() +  "\n");
      }
      writer.close();
    }catch (IOException e){
      System.out.println("Impossible de créer le FileWriter et d'écrire dans le fichier");
      e.printStackTrace();
    }
  }

  /**
   * String permettant d'afficher le contenu du paquet de carte
   * @return [String ]
   */
  public String toString(){
    String toReturn;

    toReturn = "Paquet de carte : [";

    for (Carte c : this.cartePaquet) {
      toReturn = toReturn + System.getProperty("line.separator") + c;
    }

    toReturn = toReturn + System.getProperty("line.separator") + " ] fin du Paquet ";

    return toReturn;
  }
}
