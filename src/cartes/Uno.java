package cartes;

import java.util.Scanner;
import errorHandler.ErreurUno;

public class Uno {
    private int sens;
    private int joueurActuel;
    private int nbJoueur;
    private boolean etatJeu;
    private Joueur[] tabJoueur;

    public Uno() throws ErreurUno {
        Scanner sc = new Scanner(System.in);

        // String input
        System.out.println("Entrez le nombre de bots avec qui vous voulez jouer");
        this.nbJoueur = sc.nextInt();


    }
}
