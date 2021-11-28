package cartes.tests;

import cartes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangementDeSensTest {
    ChangementDeSens changementdesens;
    Uno u1;

    @BeforeEach
    void setUp(){
        u1 = new Uno();
        changementdesens = new ChangementDeSens(u1, Couleur.BLEU);
    }

    @Test
    void getValeur() {
        assertEquals(20, changementdesens.getValeur(), "La carte ChangementDeSens ne vaut pas 20");
    }


    @Test
    void testPeutEtreRecouvertePar() {
        Plus4 plus4 = new Plus4(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtreRecouvertePar(plus4), "ChangementDeSens ne peut être recouverte par Plus4");
        Plus2 plus2 = new Plus2(u1, Couleur.BLEU);
        assertFalse(changementdesens.peutEtreRecouvertePar(plus2), "ChangementDeSens ne peut être recouverte par Plus2");
        Joker joker = new Joker(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtreRecouvertePar(joker), "ChangementDeSens ne peut être recouverte par Joker");
        PasseTonTour passeTonTour = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtreRecouvertePar(passeTonTour), "ChangementDeSens ne peut être recouverte par PasseTonTour");
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(changementdesens.peutEtreRecouvertePar(chiffre), "ChangementDeSens ne peut être recouverte par Chiffre");
        ChangementDeSens changementDeSens2 = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtreRecouvertePar(changementDeSens2), "ChangementDeSens ne peut être recouverte par ChangementDeSens");
    }

    @Test
    @DisplayName("Test avec le Plus2")
    void testPeutEtrePoseeSur() {
        Plus2 carte = new Plus2(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtrePoseeSur(carte), "Erreur : Le ChangementDeSens ne peut pas être posé sur le Plus2");
    }

    @Test
    @DisplayName("Test avec le Plus4")
    void testPeutEtrePoseeSur1() {
        Plus4 carte = new Plus4(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtrePoseeSur(carte), "Erreur : Le ChangementDeSens ne peut pas être posé sur le Plus4");
    }

    @Test
    @DisplayName("Test avec le Joker")
    void testPeutEtrePoseeSur2() {
        Joker carte = new Joker(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtrePoseeSur(carte), "Erreur : Le ChangementDeSens ne peut pas être posé sur le Joker");
    }

    @Test
    @DisplayName("Test avec le Chiffre")
    void testPeutEtrePoseeSur3() {
        Chiffre chiffre = new Chiffre(u1, Couleur.BLEU, 9);
        assertTrue(changementdesens.peutEtrePoseeSur(chiffre), "Erreur : Le ChangementDeSens ne peut pas être posé sur le Chiffre");
    }

    @Test
    @DisplayName("Test avec le Passe ton tour")
    void testPeutEtrePoseeSur4() {
        PasseTonTour carte = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtrePoseeSur(carte), "Erreur : Le ChangementDeSens ne peut pas être posé sur le PasseTonTour");
    }

    @Test
    @DisplayName("Test avec le Changement de Sens")
    void testPeutEtrePoseeSur5() {
        ChangementDeSens carte = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(changementdesens.peutEtrePoseeSur(carte), "Erreur : Le ChangementDeSens ne peut pas être posé sur le ChangementDeSens");
    }


    @Test
    @DisplayName("Test fct GetName")
    void testGetName() {
        assertEquals(changementdesens.getName(), "ChangementDeSens", "Erreur; getName ne retourne pas le nom de la classe (ChangementDeSens)");
    }
}