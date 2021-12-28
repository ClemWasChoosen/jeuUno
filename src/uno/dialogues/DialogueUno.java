package uno.dialogues;

import uno.cartes.Carte;
import uno.cartes.Couleur;
import uno.cartes.PaquetDeCartes;
import uno.cartes.Uno;
import uno.errorHandler.ErreurUno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DialogueUno {
    Uno u1;
    int nbJoueur;
    String nomJoueur;
    Scanner sc;

    public DialogueUno(Uno unoPara) throws ErreurUno {
        if (unoPara == null){
            throw new ErreurUno("Uno est null, dialogue uno ne peut être initialisé");
        }
        this.u1 = unoPara;
        this.u1.setDialogue(this);
        nbJoueur = this.lireNombreJoueur();
        System.out.println("Quel est le nom du Joueur ?");
        this.nomJoueur = lireString();
        u1.initialiser(this.nbJoueur, this.nomJoueur);
    }

    public int lireNombreJoueur(){
        sc = new Scanner(System.in);
        int nb = 0;
            do {
                System.out.println("Combien de bots voulez-vous ? (en comptant le joueur humain | nombre > 1) ");
                while (!sc.hasNextInt()) {
                    System.out.println("Valeur entrée incorrecte");
                    sc.next();
                }
                nb = sc.nextInt();
            } while (nb <= 1 || nb > 10);
        return nb;
    }

    public String lireString(){
        sc = new Scanner(System.in);
        String ligne = "";
        try {
            ligne = sc.nextLine();
        }catch (InputMismatchException i){
            lireString();
        }
        return ligne;
    }

    public void afficherPaquetJoueur(){
        if (this.u1.getNbCarteEnMainJoueur() > 0){
            System.out.println("Paquet de " + this.u1.getTabJoueur()[u1.getJoueurActuel()].getNom() + ":");
            System.out.print(this.u1.toStringPaquet());
            System.out.println();
        }
    }

    public Couleur lireCouleur(){

        sc = new Scanner(System.in);
        int couleurChoisie = 1;
        Couleur coul;
        do {
            System.out.println("Choisissez une couleur :");
            System.out.println(" (1) Jaune | (2) Vert | (3) Bleu | (4) Rouge");
            while (!sc.hasNextInt()) {
                System.out.println("Valeur entrée incorrecte");
                sc.next();
            }
            couleurChoisie = sc.nextInt();
        } while (couleurChoisie < 1 || couleurChoisie > 4);

        switch (couleurChoisie){
            case 1:
                coul = Couleur.JAUNE;
                break;
            case 2:
                coul = Couleur.VERT;
                break;
            case 3:
                coul = Couleur.BLEU;
                break;
            default:
                coul = Couleur.ROUGE;
        }

        return coul;
    }

    public String lireCoup(){
        System.out.println("\n(p) : piocher | (j) jouer une carte");
        System.out.print("Quel coup voulez vous jouer : ");
        sc = new Scanner(System.in);
        String coupAJouer;

        do {
            coupAJouer = sc.nextLine();
            if (!coupAJouer.isEmpty() && coupAJouer.charAt(0) != 'p' && coupAJouer.charAt(0) != 'j')
                System.out.println("Coup non jouable entrez en un nouveau");
        }while (!coupAJouer.isEmpty() && coupAJouer.charAt(0) != 'p' && coupAJouer.charAt(0) != 'j');

        if (coupAJouer.charAt(0) == 'j'){
            do {
                System.out.println("Quelle carte voulez-vous jouer ? (1 - " + (this.u1.getNbCarteEnMainJoueur()) + ")");
                while (!sc.hasNextInt()) {
                    System.out.println("Valeur entrée incorrecte");
                    sc.next();
                }
                coupAJouer = sc.nextInt() + "";
            }while (coupAJouer.charAt(0) == '-' && !Character.isDigit(coupAJouer.charAt(0)) && Integer.parseInt(String.valueOf(coupAJouer.charAt(0))) < this.u1.getNbCarteEnMainJoueur() && Integer.parseInt(String.valueOf(coupAJouer.charAt(0))) > 0);
        }

        return coupAJouer;
    }

    public void reagir(){
        if (!this.u1.getEtatJeu()){
        System.out.println("========\nCarte sur le talon :");
        System.out.println(" -" + u1.getTalon().getSommet());
        System.out.println("Nombre de carte dans la pioche [" + this.u1.getPioche().getNombreDeCartes() + "]");
        System.out.println("========");

        System.out.println("Au tour du joueur " + this.u1.getTabJoueur()[u1.getJoueurActuel()].getNom() + " de jouer...");
        System.out.println("Il lui reste " + this.u1.getPaquetJoueurActuel().getNombreDeCartes() + " carte(s)");

            if (this.u1.estUnJoueurHumain()){
                afficherPaquetJoueur();
                u1.jouer(lireCoup());
            }else{
                //afficherPaquetJoueur();
                u1.jouer("*");
            }
        }else{
            System.out.println(" ==== !!!! ====");
            int joueurGagnant = this.u1.getJoueurActuel();

            System.out.println(this.u1.getTabJoueur()[joueurGagnant].getNom() + " a gagné la partie, il lui reste 0 carte");

            System.out.println(" ==== !!!! ====");
        }
    }
}
