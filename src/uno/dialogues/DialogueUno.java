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
}
