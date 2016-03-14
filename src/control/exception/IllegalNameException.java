package control.exception;

public final class IllegalNameException extends CatanException {

    public IllegalNameException(final String name) {
        super("Invalid player name: " + name);
    }

}