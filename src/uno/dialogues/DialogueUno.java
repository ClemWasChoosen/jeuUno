package uno.dialogues;

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
            } while (nb <= 1);
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

    public char lireCoup(){
        System.out.println("\n(p) : piocher | (j) jouer la carte correspondante");
                //(1 - " + this.u1.getNbCarteEnMainJoueur() +
        System.out.print("Quel coup voulez vous jouer : ");
        sc = new Scanner(System.in);
        char coupAJouer;

        do {
            coupAJouer = sc.next().charAt(0);
            if (coupAJouer != 'p' && coupAJouer != 'j')
                System.out.println("Coup non jouable entrez en un nouveau");
        }while (coupAJouer != 'p' && coupAJouer != 'j');


        return coupAJouer;
    }

    public void reagir(){
        System.out.println("========\nCarte sur le talon");
        System.out.println(u1.getPioche().getSommet());
        System.out.println("========");

    }
}
