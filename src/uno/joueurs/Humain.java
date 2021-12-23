package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.errorHandler.CoupIncorrect;

public class Humain extends Joueur{
    public Humain(String nom) {
        super(nom);
    }


    @Override
    public void jouer(PaquetDeCartes talon, PaquetDeCartes pioche) {

    }

    @Override
    public boolean joueurEstHumain() {
        return true;
    }

    public void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche) throws CoupIncorrect{
        /*String carteNumberStr;
        if (coupAJouer.length() > 1)
            carteNumberStr = coupAJouer.substring(0, 2);
        else
            carteNumberStr = coupAJouer.substring(0, 1);
*/
        if (coupAJouer.charAt(0) == 'p') {
            this.paquetJoueur.ajouter(pioche.piocher());
        }else if(/*Character.isDigit(carteNumberStr.charAt(0)) &&*/ coupAJouer.charAt(0) != 'n' /*&& Character.isDigit(carteNumberStr.charAt(1))*/){
            /*if (carteNumberStr.length() > 1 && !Character.isDigit(carteNumberStr.charAt(1)))
                carteNumberStr = coupAJouer.substring(0,1);*/

            //int carteToGet = Integer.parseInt(carteNumberStr);
            //System.out.println("Carte a jouer " + carteNumberStr);
            //if (carteToGet >= 0 && carteToGet < this.paquetJoueur.getNombreDeCartes()){

            Carte c = carteChoisie(coupAJouer, talon.getSommet());
            talon.ajouter(c);
            this.paquetJoueur.enlever(c);

                //talon.ajouter(this.paquetJoueur.getCarte(carteToGet));
            //}
        }
    }

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
                    if (this.paquetJoueur.getCarte(carteToGet).getCouleur() != null)
                        return this.paquetJoueur.getCarte(carteToGet);
                    else {
                        try {
                            return choisirCouleurCarte(this.paquetJoueur.getCarte(carteToGet));
                        }catch (CoupIncorrect c){
                            c.printStackTrace();
                            choisirCouleurCarte(this.paquetJoueur.getCarte(carteToGet));;
                        }
                        System.out.println("Il faut créer ici");
                    }

                else throw new CoupIncorrect("La carte choisie ne peut pas être posée sur le talon");
                //talon.ajouter(this.paquetJoueur.getCarte(carteToGet));
            }else throw new CoupIncorrect("Valeur entrée en dehors du nombre possible de carte du paquet");
        }else
            throw new CoupIncorrect("La valeur entrée n'est pas un nombre");
    return null;
    }

    public Carte choisirCouleurCarte(Carte carteAChanger) throws CoupIncorrect{

        return null;
    }

}
