package uno.joueurs;

import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;
import uno.cartes.Uno;

public abstract class Joueur {
    protected String nom;
    protected PaquetDeCartes paquetJoueur;
    //A ajouter si necessaire dans le futur
    //protected int rang

    public Joueur(String nom){
        this.nom = nom;
        this.paquetJoueur = new PaquetDeCartes();
    }

    public PaquetDeCartes getPaquetJoueur(){
        return this.paquetJoueur;
    }

    public String getNom(){
        return this.nom;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", paquetJoueur=" + paquetJoueur +
                '}';
    }
}
