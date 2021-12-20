package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.errorHandler.CoupIncorrect;

public class Humain extends Joueur{
    public Humain(String nom) {
        super(nom);
    }

    @Override
    public boolean joueurEstHumain() {
        return true;
    }

    public void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche) {
        String carteNumberStr;
        if (coupAJouer.length() > 1)
            carteNumberStr = coupAJouer.substring(0, 2);
        else
            carteNumberStr = coupAJouer.substring(0, 1);

        if (coupAJouer.charAt(0) == 'p') {
            this.paquetJoueur.ajouter(pioche.piocher());
        }else if(coupAJouer.charAt(0) == 'n'){

        }else if(Character.isDigit(carteNumberStr.charAt(0)) && coupAJouer.charAt(0) != 'n' /*&& Character.isDigit(carteNumberStr.charAt(1))*/){
            if (carteNumberStr.length() > 1 && !Character.isDigit(carteNumberStr.charAt(1)))
                carteNumberStr = coupAJouer.substring(0,1);

            int carteToGet = Integer.parseInt(carteNumberStr);
            //System.out.println("Carte a jouer " + carteNumberStr);
            if (carteToGet >= 0 && carteToGet < this.paquetJoueur.getNombreDeCartes()){
                talon.ajouter(this.paquetJoueur.getCarte(carteToGet));
            }
        }
    }

    public Carte carteChoisie(int coup) throws CoupIncorrect {

    }

}
