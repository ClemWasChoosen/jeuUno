package cartes;

public abstract class Joueur {
    protected String nom;
    protected PaquetDeCartes pdcJoueur;
    //A ajouter si necessaire dans le futur
    //protected int rang

    public Joueur(String nom){
        this.nom = nom;
    }

    public void setPaquetJoueur(PaquetDeCartes pdcJoueur){
        this.pdcJoueur = pdcJoueur;
    }

}
