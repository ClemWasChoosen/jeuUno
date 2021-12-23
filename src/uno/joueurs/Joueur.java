package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;
import uno.cartes.Uno;
import uno.errorHandler.CoupIncorrect;

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

    public abstract Carte carteChoisie(String coupAJouer, Carte talon) throws CoupIncorrect;

    public abstract void jouer(PaquetDeCartes talon, PaquetDeCartes pioche);

    public abstract void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche) throws CoupIncorrect;

    public abstract boolean joueurEstHumain();

    public abstract Carte choisirCouleurCarte(Carte carteAChanger) throws CoupIncorrect;
}
