package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.dialogues.DialogueUno;
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

    @Override
    public void choisirCouleurCarte(Carte carteAChanger, DialogueUno diag) throws CoupIncorrect {

    }

    @Override
    public void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche, DialogueUno diag) throws CoupIncorrect {
        jouer(talon, pioche);
    }
}
