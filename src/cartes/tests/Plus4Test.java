package cartes.tests;

import cartes.*;
import errorHandler.ErreurUno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Plus4Test {
    Plus4 plus4;
    Uno u1;

    @BeforeEach
    void setUp() throws ErreurUno {
        u1 = new Uno();
        plus4 = new Plus4(u1, Couleur.BLEU);
    }

    @Test
    void getValeur() {
        assertEquals(50, plus4.getValeur(), "La carte ChangementDeSens ne vaut pas 20");
    }


    @Test
    void testPeutEtreRecouvertePar() {
        Plus2 plus2 = new Plus2(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtreRecouvertePar(plus2), "Plus4 ne peut être recouverte par Plus2");
        PasseTonTour passeTonTour = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtreRecouvertePar(passeTonTour), "Plus4 ne peut être recouverte par PasseTonTour");
        Joker joker = new Joker(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtreRecouvertePar(joker), "Plus4 ne peut être recouverte par Joker");
        ChangementDeSens changementDeSens = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtreRecouvertePar(changementDeSens), "Plus4 ne peut être recouverte par ChangementDeSens");
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(plus4.peutEtreRecouvertePar(chiffre), "Plus4 ne peut être recouverte par Chiffre");
        Plus4 plus4bis = new Plus4(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtreRecouvertePar(plus4bis), "Plus4 ne peut être recouverte par Plus4");
    }

    @Test
    @DisplayName("Test avec le Plus2")
    void testPeutEtrePoseeSur() {
        Plus2 carte = new Plus2(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtrePoseeSur(carte), "Erreur : Le Plus4 ne peut pas être posé sur le Plus2 (Meme couleur)");
    }

    @Test
    @DisplayName("Test avec le Plus4")
    void testPeutEtrePoseeSur1() {
        Plus4 carte = new Plus4(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtrePoseeSur(carte), "Erreur : Le Plus4 ne peut pas être posé sur le Plus4");
    }

    @Test
    @DisplayName("Test avec le Joker")
    void testPeutEtrePoseeSur2() {
        Joker carte = new Joker(u1, null);
        assertTrue(plus4.peutEtrePoseeSur(carte), "Erreur : Le Plus4 ne peut pas être posé sur le Joker");
    }

    @Test
    @DisplayName("Test avec le Chiffre")
    void testPeutEtrePoseeSur3() {
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(plus4.peutEtrePoseeSur(chiffre), "Erreur : Le Plus4 ne peut pas être posé sur le Chiffre");
    }

    @Test
    @DisplayName("Test avec le Passe ton tour")
    void testPeutEtrePoseeSur4() {
        PasseTonTour carte = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtrePoseeSur(carte), "Erreur : Le Plus4 ne peut pas être posé sur le PasseTonTour");
    }

    @Test
    @DisplayName("Test avec le Changement de Sens")
    void testPeutEtrePoseeSur5() {
        ChangementDeSens carte = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(plus4.peutEtrePoseeSur(carte), "Erreur : Le Plus4 ne peut pas être posé sur le ChangementDeSens");
    }


    @Test
    @DisplayName("Test fct GetName")
    void testGetName() {
        assertEquals(plus4.getName(), "PlusQuatre", "Erreur; getName ne retourne pas le nom de la classe (Plus4)");
    }
}