package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.errorHandler.CoupIncorrect;

public class Bots extends Joueur{
    public Bots(String nom) {
        super(nom);
    }

    @Override
    public Carte carteChoisie(String coupAJouer, Carte talon) throws CoupIncorrect {
        return null;
    }


    public boolean joueurEstHumain() {
        return false;
    }

    public void jouer(PaquetDeCartes talon, PaquetDeCartes pioche){
        Carte cartEnlevee = null;
        int rand = (int)(Math.random() * this.paquetJoueur.getNombreDeCartes());
        if (this.paquetJoueur.getNombreDeCartes() > 0){
            if (talon.getSommet().getCouleur() == null)
                cartEnlevee = this.paquetJoueur.enlever(this.paquetJoueur.getCarte(rand));

            for (int i = 0; i < this.paquetJoueur.getNombreDeCartes(); i++){
                if (talon.getSommet().peutEtreRecouvertePar(this.paquetJoueur.getCarte(i))){
                    cartEnlevee = this.paquetJoueur.enlever(this.paquetJoueur.getCarte(i));
                    break;
                }
            }
        }

        if (cartEnlevee != null){
            talon.ajouter(cartEnlevee);
        }else if(this.paquetJoueur.getNombreDeCartes() > 0){
            this.paquetJoueur.ajouter(pioche.piocher());
        }
    }

    @Override
    public void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche) throws CoupIncorrect {

    }
}
