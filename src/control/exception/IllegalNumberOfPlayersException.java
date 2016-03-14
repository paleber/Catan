package control.exception;

public final class IllegalNumberOfPlayersException extends CatanException {

    public IllegalNumberOfPlayersException(int min, int max) {
        super("Only " + min + " to " + max + " players allowed");
    }

}
