package uno.joueurs;

public class Bots extends Joueur{
    public Bots(String nom) {
        super(nom);
    }

    public boolean joueurEstHumain() {
        return false;
    }
}
