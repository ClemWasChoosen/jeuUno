package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.Couleur;
import uno.cartes.PaquetDeCartes;
import uno.dialogues.DialogueUno;
import uno.errorHandler.CoupIncorrect;

/**
 * Classe pour les joueurs humain, avec interaction avec les entrées et sorties
 */
public class Humain extends Joueur{
    /**
     * Constructeur de la classe Humain
     * @param nom nom donné au joueur
     */
    public Humain(String nom) {
        super(nom);
    }

    /**
     * @return true car le joueur est humain
     */
    @Override
    public boolean joueurEstHumain() {
        return true;
    }

    /**
     * Fonction permettant de jouer une carte, elle fait appel à carteChoisie()
     * @param coupAJouer contient ce que le joueur veut jouer
     * @param talon talon du jeu de Uno actuel
     * @param pioche pioche du jeu de Uno actuel
     * @param diag dialogueUno pour demander à l'utilisateur la couleur de la carte si besoin
     * @throws CoupIncorrect erreur quand le joueur joue une carte non valide
     */
    public void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche, DialogueUno diag) throws CoupIncorrect{
        if (coupAJouer.charAt(0) == 'p') {
            this.paquetJoueur.ajouter(pioche.piocher());
        }else/*(Character.isDigit(carteNumberStr.charAt(0)) && coupAJouer.charAt(0) != 'n' && Character.isDigit(carteNumberStr.charAt(1)))*/{
            Carte c = carteChoisie(coupAJouer, talon.getSommet());

            if (c.getCouleur() == null){
                choisirCouleurCarte(c, diag);
            }

            c.appliquerEffet();
            talon.ajouter(c);
            this.paquetJoueur.enlever(c);
        }
    }

    /**
     * Vérifie la validité d'une carte :
     * erreur quand:
     *      - la carte ne peut pas être posée sur le talon
     *      - la valeur entrée est en dehors du nombre de cartes dans le paquet du joueur
     *      - la valeur entrée n'est pas un nombre
     * pas d'erreur:
     *      retourne la carte à jouer
     * @param coupAJouer carte que le joueur veut jouer
     * @param talon talon du jeu de Uno actuel
     * @return la carte à jouer si il n'y a pas eu d'erreur
     * @throws CoupIncorrect erreur en fonction de la validité de la carte jouée
     */
    public Carte carteChoisie(String coupAJouer, Carte talon) throws CoupIncorrect {

        String carteNumberStr;
        if (coupAJouer.length() > 1)
            carteNumberStr = coupAJouer.substring(0, 2);
        else if (coupAJouer.length() != 0)
            carteNumberStr = coupAJouer.substring(0, 1);
        else throw new CoupIncorrect("Aucune valeur n'est entrée pour la selection d'une carte");

        if (Character.isDigit(carteNumberStr.charAt(0)) /*&& Character.isDigit(carteNumberStr.charAt(1))*/) {
            if (carteNumberStr.length() > 1 && !Character.isDigit(carteNumberStr.charAt(1)))
                carteNumberStr = coupAJouer.substring(0, 1);

            int carteToGet = Integer.parseInt(carteNumberStr) - 1;
            //System.out.println("Carte a jouer " + carteNumberStr);
            if (carteToGet >= 0 && carteToGet < this.paquetJoueur.getNombreDeCartes()) {
                if (talon.peutEtreRecouvertePar(this.paquetJoueur.getCarte(carteToGet)))
                    return this.paquetJoueur.getCarte(carteToGet);

                else throw new CoupIncorrect("La carte choisie ne peut pas être posée sur le talon");
            }else throw new CoupIncorrect("Valeur entrée en dehors du nombre possible de carte du paquet");
        }else
            throw new CoupIncorrect("La valeur entrée n'est pas un nombre");
    }

    /**
     * Demande à l'humain de choisir une couleur pour la carte
     * @param carteAChanger carte qui n'a pas de couleur
     * @param diag fait appel à la fonction lireCouleur() du dialogueUno
     */
    public void choisirCouleurCarte(Carte carteAChanger, DialogueUno diag){
        carteAChanger.setCouleur(diag.lireCouleur());
    }

}
