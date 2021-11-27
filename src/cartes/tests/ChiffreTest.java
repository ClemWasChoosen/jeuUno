package cartes.tests;


import cartes.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.SplitPaneUI;

import static org.junit.jupiter.api.Assertions.*;

class ChiffreTest {

    Chiffre chiffre;
    Uno u1;

    @BeforeEach
    void setUp(){
        u1 = new Uno();
        chiffre = new Chiffre(u1, Couleur.BLEU, 9);
    }

    @Test
    @DisplayName("Valeur retournée")
    void testGetValeur() {
        assertEquals(chiffre.getValeur(), 9, "Le Chiffre fixé à 9 ne vaut pas 9");
    }

    @Test
    void testPeutEtreRecouvertePar() {
       // assertEquals(chiffre.peutEtreRecouvertePar());
    }

    @Test
    @DisplayName("Test avec le Plus2")
    void testPeutEtrePoseeSur() {
        Plus2 carte = new Plus2(u1, Couleur.BLEU);
        assertTrue(chiffre.peutEtrePoseeSur(carte), "Erreur : Le Chiffre ne peut pas être posé sur le Plus2 (Meme couleur)");
    }

    @Test
    @DisplayName("Test avec le Plus4")
    void testPeutEtrePoseeSur1() {
        Plus4 carte = new Plus4(u1, Couleur.BLEU);
        assertTrue(chiffre.peutEtrePoseeSur(carte), "Erreur : Le Chiffre ne peut pas être posé sur le Plus4 (Meme couleur)");
    }

    @Test
    @DisplayName("Test avec le Joker")
    void testPeutEtrePoseeSur2() {
        Joker carte = new Joker(u1, null);
        assertTrue(chiffre.peutEtrePoseeSur(carte), "Erreur : Le Chiffre ne peut pas être posé sur le Joker (??)");
    }

    @Test
    @DisplayName("Test avec le Chiffre")
    void testPeutEtrePoseeSur3() {
        Chiffre carte = new Chiffre(u1, Couleur.ROUGE, 9);
        assertFalse(chiffre.peutEtrePoseeSur(carte), "Erreur : Le Chiffre ne peut pas être posé sur le Chiffre (Erreur Couleur)");
        Chiffre carte2 = new Chiffre(u1, Couleur.BLEU, 3);
        assertFalse(chiffre.peutEtrePoseeSur(carte2), "Erreur : Le Chiffre ne peut pas être posé sur le Chiffre (Erreur valeur)");
    }

    @Test
    @DisplayName("Test avec le Passe ton tour")
    void testPeutEtrePoseeSur4() {
        PasseTonTour carte = new PasseTonTour(u1, Couleur.BLEU);
        assertTrue(chiffre.peutEtrePoseeSur(carte), "Erreur : Le Chiffre ne peut pas être posé sur le PasseTonTour (Meme couleur)");
    }

    @Test
    @DisplayName("Test avec le Changement de Sens")
    void testPeutEtrePoseeSur5() {
        ChangementDeSens carte = new ChangementDeSens(u1, Couleur.BLEU);
        assertTrue(chiffre.peutEtrePoseeSur(carte), "Erreur : Le Chiffre ne peut pas être posé sur le Changement de Sens (Meme couleur)");
    }


    @Test
    @DisplayName("Test fct GetName")
    void testGetName() {
        assertEquals(chiffre.getName(), "Chiffre", "Erreur; getName ne retourne pas le nom de la classe (Chiffre)");
    }
}