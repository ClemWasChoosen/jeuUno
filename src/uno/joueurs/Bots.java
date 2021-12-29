package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.PaquetDeCartes;
import uno.dialogues.DialogueUno;
import uno.errorHandler.CoupIncorrect;

/**
 * La classe gère les fonctions propres aux joueurs non humains
 */
public class Bots extends Joueur{
    /**
     * Constructeur de la classe Bots
     * @param nom nom du bots
     */
    public Bots(String nom) {
        super(nom);
    }

    /**
     * Fonction ne faisant rien -> les bots ne choisissent pas de carte
     */
    @Override
    public Carte carteChoisie(String coupAJouer, Carte talon) throws CoupIncorrect {
        return null;
    }


    /**
     * @return false car le joueur est un bot pas un humain
     */
    public boolean joueurEstHumain() {
        return false;
    }

    /**
     * Fonction ne faisant rien -> les bots ne choisissent pas de couleur elle est choisie
     * aléatoirement
     */
    @Override
    public void choisirCouleurCarte(Carte carteAChanger, DialogueUno diag) throws CoupIncorrect {

    }

    /**
     * Si cette fonction est appelée, elle joue automatiquement en appellant jouer(talon, pioche)
     * car un bot ne choisis pas ce qu'il joue.
     */
    @Override
    public void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche, DialogueUno diag) throws CoupIncorrect {
        jouer(talon, pioche);
    }
}
