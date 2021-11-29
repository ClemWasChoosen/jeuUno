package cartes.tests;

import cartes.FabriqueCartes;
import errorHandler.ErreurFichier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaquetDeCartesTest {
    FabriqueCartes fabCarte;

    @BeforeEach
    void setUp(){
        fabCarte = FabriqueCartes.getInstance();
    }

    @Test
    void ecrire() {
        try{
            fabCarte.getPaquetComplet().ecrire("PaquetDeCarteTest.txt");
        }catch (ErreurFichier e){
            e.printStackTrace();
            fail();
        }
    }
}