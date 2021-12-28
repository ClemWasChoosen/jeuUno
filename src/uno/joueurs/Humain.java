package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.Couleur;
import uno.cartes.PaquetDeCartes;
import uno.dialogues.DialogueUno;
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

    public void choisirCouleurCarte(Carte carteAChanger, DialogueUno diag){
        carteAChanger.setCouleur(diag.lireCouleur());
    }

}
