package cartes.tests;

import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokerTest {

    Joker joker;
    Uno u1;

    @BeforeEach
    void setUp(){
        u1 = new Uno();
        joker = new Joker(u1, null);
    }

    @Test
    void getValeur() {
        assertEquals(50, joker.getValeur(), "La carte ChangementDeSens ne vaut pas 20");
    }

    @Test
    void testPeutEtreRecouvertePar() {
        Plus2 plus2 = new Plus2(u1, Couleur.BLEU);
        assertTrue(joker.peutEtreRecouvertePar(plus2), "Joker ne peut être recouverte par Plus4");
        PasseTonTour passeTonTour = new PasseTonTour(u1, Couleur.BLEU);
        //La couleur de Joker est fixée à null dans ces tests
        assertFalse(joker.peutEtreRecouvertePar(passeTonTour), "Joker ne peut être recouverte par Plus2");
        Plus4 plus4 = new Plus4(u1, Couleur.BLEU);
        assertTrue(joker.peutEtreRecouvertePar(plus4), "Joker ne peut être recouverte par Plus4");
        ChangementDeSens changementDeSens = new ChangementDeSens(u1, Couleur.BLEU);
        //Pareil qu'au dessus
        assertFalse(joker.peutEtreRecouvertePar(changementDeSens), "Joker ne peut être recouverte par ChangementDeSens");
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(joker.peutEtreRecouvertePar(chiffre), "Joker ne peut être recouverte par Chiffre");
        Joker joker2 = new Joker(u1, Couleur.BLEU);
        assertTrue(joker.peutEtreRecouvertePar(joker2), "Joker ne peut être recouverte par Joker");

    }

    @Test
    @DisplayName("Test avec le Plus2")
    void testPeutEtrePoseeSur() {
        Plus2 carte = new Plus2(u1, Couleur.BLEU);
        assertTrue(joker.peutEtrePoseeSur(carte), "Erreur : Le Joker ne peut pas être posé sur le Plus2 (Meme couleur)");
    }

    @Test
    @DisplayName("Test avec le Plus4")
    void testPeutEtrePoseeSur1() {
        Plus4 carte = new Plus4(u1, Couleur.BLEU);
        assertTrue(joker.peutEtrePoseeSur(carte), "Erreur : Le Joker ne peut pas être posé sur le Plus4");
    }

    @Test
    @DisplayName("Test avec le Joker")
    void testPeutEtrePoseeSur2() {
        Joker carte = new Joker(u1, null);
        assertTrue(joker.peutEtrePoseeSur(carte), "Erreur : Le Joker ne peut pas être posé sur le Joker");
    }

    @Test
    @DisplayName("Test avec le Chiffre")
    void testPeutEtrePoseeSur3() {
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(joker.peutEtrePoseeSur(chiffre), "Erreur : Le Joker ne peut pas être posé sur le Chiffre");
    }

    @Test
    @DisplayName("Test avec le Passe ton tour")
    void testPeutEtrePoseeSur4() {
        PasseTonTour carte = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(joker.peutEtrePoseeSur(carte), "Erreur : Le Joker ne peut pas être posé sur le PasseTonTour");
    }

    @Test
    @DisplayName("Test avec le Changement de Sens")
    void testPeutEtrePoseeSur5() {
        ChangementDeSens carte = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(joker.peutEtrePoseeSur(carte), "Erreur : Le Joker ne peut pas être posé sur le ChangementDeSens");
    }


    @Test
    @DisplayName("Test fct GetName")
    void testGetName() {
        assertEquals(joker.getName(), "Joker", "Erreur; getName ne retourne pas le nom de la classe (Joker)");
    }
}