package cartes.tests;

import cartes.*;
import errorHandler.ErreurUno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasseTonTourTest {

    PasseTonTour passeTonTour;
    Uno u1;

    @BeforeEach
    void setUp() throws ErreurUno {
        u1 = new Uno();
        passeTonTour = new PasseTonTour(u1, Couleur.BLEU);
    }

    @Test
    void getValeur() {
        assertEquals(20, passeTonTour.getValeur(), "La carte PasseTonTour ne vaut pas 20");
    }

    @Test
    void testPeutEtreRecouvertePar() {
        Plus4 plus4 = new Plus4(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtreRecouvertePar(plus4), "PasseTonTour ne peut être recouverte par Plus4");
        Plus2 plus2 = new Plus2(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtreRecouvertePar(plus2), "PasseTonTour ne peut être recouverte par Plus2");
        Joker joker = new Joker(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtreRecouvertePar(joker), "PasseTonTour ne peut être recouverte par Joker");
        ChangementDeSens changementDeSens = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtreRecouvertePar(changementDeSens), "PasseTonTour ne peut être recouverte par ChangementDeSens");
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(passeTonTour.peutEtreRecouvertePar(chiffre), "PasseTonTour ne peut être recouverte par Chiffre");
        PasseTonTour passeTonTour2 = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtreRecouvertePar(passeTonTour2), "PasseTonTour ne peut être recouverte par PasseTonTour");

    }

    @Test
    @DisplayName("Test avec le Plus2")
    void testPeutEtrePoseeSur() {
        Plus2 carte = new Plus2(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtrePoseeSur(carte), "Erreur : Le PasseTonTour ne peut pas être posé sur le Plus2");
    }

    @Test
    @DisplayName("Test avec le Plus4")
    void testPeutEtrePoseeSur1() {
        Plus4 carte = new Plus4(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtrePoseeSur(carte), "Erreur : Le PasseTonTour ne peut pas être posé sur le Plus4");
    }

    @Test
    @DisplayName("Test avec le Joker")
    void testPeutEtrePoseeSur2() {
        Joker carte = new Joker(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtrePoseeSur(carte), "Erreur : Le PasseTonTour ne peut pas être posé sur le Joker");
    }

    @Test
    @DisplayName("Test avec le Chiffre")
    void testPeutEtrePoseeSur3() {
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(passeTonTour.peutEtrePoseeSur(chiffre), "Erreur : Le PasseTonTour ne peut pas être posé sur le Chiffre");
    }

    @Test
    @DisplayName("Test avec le Passe ton tour")
    void testPeutEtrePoseeSur4() {
        PasseTonTour carte = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtrePoseeSur(carte), "Erreur : Le PasseTonTour ne peut pas être posé sur le PasseTonTour");
    }

    @Test
    @DisplayName("Test avec le Changement de Sens")
    void testPeutEtrePoseeSur5() {
        ChangementDeSens carte = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(passeTonTour.peutEtrePoseeSur(carte), "Erreur : Le PasseTonTour ne peut pas être posé sur le ChangementDeSens");
    }


    @Test
    @DisplayName("Test fct GetName")
    void testGetName() {
        assertEquals(passeTonTour.getName(), "PasseTonTour", "Erreur; getName ne retourne pas le nom de la classe (PasseTonTour)");
    }
}