package tests;

import uno.cartes.Carte;
import uno.cartes.FabriqueCartes;
import uno.errorHandler.ErreurFichier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaquetDeCartesTest {
    FabriqueCartes fabCarte;

    @BeforeEach
    void setUp(){
        fabCarte = FabriqueCartes.getInstance();
    }

    @Test
    @DisplayName("Test de la fonction lire")
    void ecrireTest() {
        try{
            fabCarte.getPaquet5Vert().ecrire("PaquetDeCarteTest.txt");
        }catch (ErreurFichier e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @DisplayName("Test de la fonction lire")
    void lireTest(){
        try{
            fabCarte.getPaquetComplet().lire("PaquetDeCarteTest.txt");
            System.out.println(fabCarte);
        }catch (ErreurFichier e){
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    @DisplayName("Tests sur l'iterateur")
    void iteratorTest(){
        for (Carte c :
                this.fabCarte.getPaquet5Vert()) {
            System.out.println(c);
        }
    }
}