package cartes.tests;

import cartes.Carte;
import cartes.FabriqueCartes;
import cartes.Uno;
import errorHandler.ErreurFichier;
import errorHandler.ErreurUno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaquetDeCartesTest {
    FabriqueCartes fabCarte;
    Uno u1;

    @BeforeEach
    void setUp() throws ErreurUno {
        u1 = new Uno();
        fabCarte = FabriqueCartes.getInstance();
    }

    @Test
    @DisplayName("Test de la fonction lire")
    void ecrireTest() {
        try{
            fabCarte.getPaquet5Vert(u1).ecrire("PaquetDeCarteTest.txt");
        }catch (ErreurFichier | ErreurUno e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @DisplayName("Test de la fonction lire")
    void lireTest() {
        try{
            fabCarte.getPaquetComplet(u1).lire("PaquetDeCarteTest.txt");
            System.out.println(fabCarte);
        }catch (ErreurFichier | ErreurUno e){
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    @DisplayName("Tests sur l'iterateur")
    void iteratorTest() throws ErreurUno {
        for (Carte c :
                this.fabCarte.getPaquet5Vert(u1)) {
            System.out.println(c);
        }
    }
}