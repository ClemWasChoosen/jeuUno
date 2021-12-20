package uno.errorHandler;

public class CoupIncorrect extends Exception{
    public CoupIncorrect(String errorMessage) {
        super("Le coup joué n'est pas valide : " + errorMessage);
    }

}
