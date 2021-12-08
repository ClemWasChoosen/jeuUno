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
        int limiteEntree = 0;
        System.out.println("Entrez le nombre de bots avec qui vous voulez jouer");
        do {
            this.nbJoueur = sc.nextInt();
            limiteEntree++;

            if (limiteEntree >= 15)
                throw new ErreurUno("Impossible de créer le jeu, le nombre de joueur est n'est pas compris entre 1 et 7");
            if (this.nbJoueur < 0 || this.nbJoueur > 7)
                System.out.println(this.nbJoueur + " n'est pas compris entre 1 et 7, réessayez");

        }while (this.nbJoueur < 0 || this.nbJoueur > 7);

        initialiser(this.nbJoueur);

    }

    public void initialiser(int nbJoueurL){
    }
}
