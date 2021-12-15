package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uno.cartes.Uno;

import static org.junit.jupiter.api.Assertions.*;

class UnoTest {
    Uno uTest;
    @BeforeEach
    void setUp() {
        uTest = new Uno();
    }

    @Test
    void creerLesJoueur() {
        uTest.creerLesJoueur(4, "JoueurTest");
        assertEquals(uTest.getNbJoueur(), 4, "Erreur; Uno le nombre de joueur n'est pas juste");
        for (int i = 1; i < uTest.getNbJoueur(); i++){
            if (i == 1)
                assertEquals(uTest.getTabJoueur()[i].getNom(), i + "erBots", "Erreur: le nom des bots ne correspond pas au nom dans unoTest");
            else
                assertEquals(uTest.getTabJoueur()[i].getNom(), i + "emeBots", "Erreur: le nom des bots ne correspond pas au nom dans unoTest");
        }
    }

    @Test
    void distribuerCarte() {
    }

    @Test
    void choisirQuiJoue() {
    }
}