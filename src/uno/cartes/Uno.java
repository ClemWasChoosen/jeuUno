package uno.cartes;

import java.util.Scanner;
import uno.errorHandler.ErreurUno;
import uno.joueurs.Bots;
import uno.joueurs.Humain;
import uno.joueurs.Joueur;

public class Uno {
    private int sens;
    private int joueurActuel;
    private int nbJoueur;
    //private boolean etatJeu;
    private Joueur[] tabJoueur;
    private PaquetDeCartes talon;
    private PaquetDeCartes pioche;

    public Uno() {
    }

    public void initialiser(int nbJoueurL) throws ErreurUno{
        Scanner sc = new Scanner(System.in);
        int limiteEntree = 0;
        System.out.println("Entrez le nombre de bots avec qui vous voulez jouer");
        do {
            this.nbJoueur = sc.nextInt();
            limiteEntree++;

            if (limiteEntree >= 15)
                throw new ErreurUno("Impossible de créer le jeu, le nombre de joueur est n'est pas compris entre 2 et 7");
            if (this.nbJoueur < 2 || this.nbJoueur > 7)
                System.out.println(this.nbJoueur + " n'est pas compris entre 1 et 7, réessayez");

        }while (this.nbJoueur < 2 || this.nbJoueur > 7);

        creerLesJoueur(nbJoueurL);
        distribuerCarte();
        choisirQuiJoue();
    }

    public void creerLesJoueur(int nbJoueurL){
        this.tabJoueur = new Joueur[nbJoueurL];

        Scanner sc = new Scanner(System.in);
        String nomJoueur = sc.nextLine();
        System.out.println("Entrez votre nom de joueur");
        this.tabJoueur[0] = new Humain(nomJoueur);

        for (int i = 1; i < nbJoueurL; i++){
            String nomBot;
            if (i == 1)
                nomBot = i + "erBots";
            else
                nomBot = i + "emeBots";

            this.tabJoueur[i] = new Bots(nomBot);
        }
    }

    public void distribuerCarte() throws ErreurUno{
        this.pioche.melanger();
        if (this.tabJoueur == null)
            throw new ErreurUno("Impossible de distribuer les uno.cartes, le tableau contenant les uno.joueurs est à null");

        this.pioche = FabriqueCartes.getInstance().getPaquetComplet();
        this.talon = new PaquetDeCartes();
        for (int i = 0; i < this.nbJoueur; i++){
            for (int j = 0; j < 7; j++){
                this.pioche.ajouter(this.tabJoueur[i].getPaquetJoueur().piocher());
            }
        }
    }

    public void choisirQuiJoue(){
        this.joueurActuel = (int)(Math.random() * 4);
        this.sens = 1;
    }
}
