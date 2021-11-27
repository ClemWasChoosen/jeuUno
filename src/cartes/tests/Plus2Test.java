package cartes.tests;

import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Plus2Test {
    Plus2 plus2;
    Uno u1;

    @BeforeEach
    void setUp(){
        u1 = new Uno();
        plus2 = new Plus2(u1, Couleur.BLEU);
    }

    @Test
    void testPeutEtreRecouvertePar() {
        // assertEquals(chiffre.peutEtreRecouvertePar());
    }

    @Test
    @DisplayName("Test avec le Plus2")
    void testPeutEtrePoseeSur() {
        Plus2 carte = new Plus2(u1, Couleur.BLEU);
        assertTrue(plus2.peutEtrePoseeSur(carte), "Erreur : Le Plus2 ne peut pas être posé sur le Plus2");
    }

    @Test
    @DisplayName("Test avec le Plus4")
    void testPeutEtrePoseeSur1() {
        Plus4 carte = new Plus4(u1, Couleur.BLEU);
        assertTrue(plus2.peutEtrePoseeSur(carte), "Erreur : Le Plus2 ne peut pas être posé sur le Plus4");
    }

    @Test
    @DisplayName("Test avec le Joker")
    void testPeutEtrePoseeSur2() {
        Joker carte = new Joker(u1, null);
        assertTrue(plus2.peutEtrePoseeSur(carte), "Erreur : Le Plus2 ne peut pas être posé sur le Joker");
    }

    @Test
    @DisplayName("Test avec le Chiffre")
    void testPeutEtrePoseeSur3() {
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(plus2.peutEtrePoseeSur(chiffre), "Erreur : Le Plus2 ne peut pas être posé sur le Chiffre");
    }

    @Test
    @DisplayName("Test avec le Passe ton tour")
    void testPeutEtrePoseeSur4() {
        PasseTonTour carte = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(plus2.peutEtrePoseeSur(carte), "Erreur : Le Plus2 ne peut pas être posé sur le PasseTonTour");
    }

    @Test
    @DisplayName("Test avec le Changement de Sens")
    void testPeutEtrePoseeSur5() {
        ChangementDeSens carte = new ChangementDeSens(u1, Couleur.BLEU);
        assertFalse(plus2.peutEtrePoseeSur(carte), "Erreur : Le Plus2 ne peut pas être posé sur le ChangementDeSens");
    }


    @Test
    @DisplayName("Test fct GetName")
    void testGetName() {
        assertEquals(plus2.getName(), "Plus2", "Erreur; getName ne retourne pas le nom de la classe (Plus2)");
    }
}