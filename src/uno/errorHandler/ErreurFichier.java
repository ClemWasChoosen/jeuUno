package uno.errorHandler;

/**
 * Gère les erreurs liées à la lecture et écriture dans un fichier
 */
public class ErreurFichier extends Exception{
    public ErreurFichier(String errorMessage){
        super(errorMessage);
    }
}
