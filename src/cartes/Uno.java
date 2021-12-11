package cartes;

import java.util.Arrays;
import java.util.Scanner;
import errorHandler.ErreurUno;

public class Uno {
    private int sens;
    private int joueurActuel;
    private int nbJoueur;
    private boolean etatJeu;
    private Joueur[] tabJoueur;
    private PaquetDeCartes pioche;
    private PaquetDeCartes talon;

    public Uno() throws ErreurUno {
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

        initialiser(this.nbJoueur);

    }

    public void initialiser(int nbJoueurL) throws ErreurUno {
        creerLesJoueur(nbJoueurL);
        this.pioche = FabriqueCartes.getInstance().getPaquetComplet(this);
        this.pioche.melanger();
        distribuerCarte();
        choisirQuiJoue();
        this.talon.ajouter(this.pioche.piocher());
    }

    public void creerLesJoueur(int nbJoueurL) throws ErreurUno {
        this.tabJoueur = new Joueur[nbJoueurL];

        Scanner sc = new Scanner(System.in);
        String nomJoueur = sc.nextLine();
        System.out.println("Entrez votre nom de joueur :");
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
        if (this.tabJoueur == null)
            throw new ErreurUno("Impossible de distribuer les cartes, le tableau contenant les joueurs est à null");

        PaquetDeCartes tmp = new PaquetDeCartes(7);

        for (int i = 0; i < this.nbJoueur; i++){
            tmp.clearPaquet();
            for (int j = 0; j < 7; j++)
                tmp.ajouter(this.talon.piocher());

            this.tabJoueur[i].setPaquetJoueur(tmp);
        }
    }

    public void choisirQuiJoue(){
        this.joueurActuel = (int)(Math.random() * this.nbJoueur);
        this.sens = 0;
    }

    @Override
    public String toString() {
        return "Uno{" +
                "sens=" + sens +
                ", joueurActuel=" + joueurActuel +
                ", nbJoueur=" + nbJoueur +
                ", etatJeu=" + etatJeu +
                ", tabJoueur=" + Arrays.toString(tabJoueur) +
                ", pioche=" + pioche +
                ", talon=" + talon +
                '}';
    }
}

