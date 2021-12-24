package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;
import uno.cartes.Uno;
import uno.dialogues.DialogueUno;
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

    public abstract void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche, DialogueUno diag) throws CoupIncorrect;

    public abstract boolean joueurEstHumain();

    public abstract void choisirCouleurCarte(Carte carteAChanger, DialogueUno diag) throws CoupIncorrect;
}
