package control.exception;

public class NameInUseException extends CatanException {

    public NameInUseException(final String name) {
        super("Name already in use: " + name);
    }

}
