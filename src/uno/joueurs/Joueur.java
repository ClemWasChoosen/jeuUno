package uno.joueurs;

import uno.cartes.Uno;

public abstract class Joueur {
    protected String nom;
    protected Uno u;
    //A ajouter si necessaire dans le futur
    //protected int rang

    public Joueur(String nom){
        this.nom = nom;
    }

    public void setUno(Uno uno){
        this.u = uno;
    }

}
