package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.cartes.PaquetDeCartes;
import uno.cartes.Uno;
import uno.errorHandler.ErreurUno;
import uno.joueurs.Joueur;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest {
    Uno uTest;

    @BeforeEach
    void setUp(){
        uTest = new Uno();
    }

    @Test
    void initialiser() {
    }

    @Test
    void creerLesJoueur() {
        uTest.creerLesJoueur(4);
        System.out.println(uTest);
    }

    @Test
    void distribuerCarte() {
        uTest.creerLesJoueur(4);
        try{
            uTest.distribuerCarte();
        }catch(ErreurUno e){
            e.printStackTrace();
        }
        //System.out.println(uTest.getNbJoueur());
        for (int j = 0; j < uTest.getNbJoueur(); j++){
            //System.out.println(uTest.getTabJoueur()[j].getPaquetJoueur());
            assertEquals(uTest.getTabJoueur()[j].getPaquetJoueur().getNombreDeCartes(), 7, "Erreur: un des paquet n'a pas 7 cartes à l'initialisation");
        }
        assertEquals(uTest.getPioche().getNombreDeCartes(), 108 - 7*uTest.getNbJoueur());
        //System.out.println(uTest.getTabJoueur()[0]);
    }

    @Test
    void choisirQuiJoue() {
    }
}