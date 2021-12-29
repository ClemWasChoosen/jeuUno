package uno.errorHandler;

/**
 * Permet de générer les erreurs liées au coup joué par un joueur, pour tester la validité d'une carte
 */
public class CoupIncorrect extends Exception{
    public CoupIncorrect(String errorMessage) {
        super("Le coup joué n'est pas valide : " + errorMessage);
    }

}
