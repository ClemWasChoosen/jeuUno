package uno.joueurs;

public class Humain extends Joueur{
    public Humain(String nom) {
        super(nom);
    }

    @Override
    public boolean joueurEstHumain() {
        return true;
    }


}
