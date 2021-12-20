package uno.joueurs;

import uno.cartes.Carte;
import uno.cartes.FabriqueCartes;
import uno.cartes.PaquetDeCartes;
import uno.cartes.Uno;

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

    public void jouer(String coupAJouer, PaquetDeCartes talon, PaquetDeCartes pioche){
        String carteNumberStr;
        if (coupAJouer.length() > 1)
            carteNumberStr = coupAJouer.substring(0, 2);
        else
            carteNumberStr = coupAJouer.substring(0, 1);

        if (coupAJouer.charAt(0) == 'p'){
            this.paquetJoueur.ajouter(pioche.piocher());
        }else if(Character.isDigit(carteNumberStr.charAt(0)) /*&& Character.isDigit(carteNumberStr.charAt(1))*/){
            if (carteNumberStr.length() > 1 && !Character.isDigit(carteNumberStr.charAt(1)))
                carteNumberStr = coupAJouer.substring(0,1);

            int carteToGet = Integer.parseInt(carteNumberStr);
            //System.out.println("Carte a jouer " + carteNumberStr);
            if (carteToGet >= 0 && carteToGet < this.paquetJoueur.getNombreDeCartes()){
                talon.ajouter(this.paquetJoueur.getCarte(carteToGet));
            }
        }



    }

    public void jouer(PaquetDeCartes talon, PaquetDeCartes pioche){
        Carte cartEnlevee = null;
        if (this.paquetJoueur.getNombreDeCartes() > 0){
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

    public abstract boolean joueurEstHumain();
}
