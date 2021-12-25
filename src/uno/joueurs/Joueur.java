package uno.joueurs;

import uno.cartes.*;
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
        //int rand = (int)(Math.random() * this.paquetJoueur.getNombreDeCartes());
        if (this.paquetJoueur.getNombreDeCartes() > 0){
            /*if (talon.getSommet().getCouleur() == null)
                cartEnlevee = this.paquetJoueur.enlever(this.paquetJoueur.getCarte(rand));*/

            for (int i = 0; i < this.paquetJoueur.getNombreDeCartes(); i++){
                if (talon.getSommet().peutEtreRecouvertePar(this.paquetJoueur.getCarte(i))){
                    cartEnlevee = this.paquetJoueur.enlever(this.paquetJoueur.getCarte(i));
                    cartEnlevee.appliquerEffet();
                    break;
                }
            }
        }

        if (cartEnlevee != null){
            if (cartEnlevee.getCouleur() == null)
                cartEnlevee.setCouleur(getRandColor());
            talon.ajouter(cartEnlevee);
        }else if(this.paquetJoueur.getNombreDeCartes() > 0){
            this.paquetJoueur.ajouter(pioche.piocher());
        }
    }

    public Couleur getRandColor(){
        int rand = (int)(Math.random() * 4);
        Couleur coul;
        switch (rand){
            case 0:
                coul = Couleur.ROUGE;
                break;
            case 1:
                coul = Couleur.BLEU;
                break;
            case 2:
                coul = Couleur.VERT;
                break;
            default:
                coul = Couleur.JAUNE;
                break;
        }

        return coul;
    }

    public abstract void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche, DialogueUno diag) throws CoupIncorrect;

    public abstract boolean joueurEstHumain();

    public abstract void choisirCouleurCarte(Carte carteAChanger, DialogueUno diag) throws CoupIncorrect;
}
