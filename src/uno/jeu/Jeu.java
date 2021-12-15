package uno.jeu;

import uno.cartes.Uno;
import uno.dialogues.DialogueUno;
import uno.errorHandler.ErreurUno;

public class Jeu {
    public static void main(String[] args) {
        Uno u1 = new Uno();
        try{
            DialogueUno diag = new DialogueUno(u1);
        }catch (ErreurUno e){
            e.printStackTrace();
        }

        System.out.println(u1);
    }
}
