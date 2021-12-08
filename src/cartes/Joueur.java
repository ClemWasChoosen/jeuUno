package cartes;

public abstract class Joueur {
    protected String nom;
    protected Uno u;

    public Joueur(String nom){
        this.nom = nom;
    }

    public void setUno(Uno uno){
        this.u = uno;
    }

}
