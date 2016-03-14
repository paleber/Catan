package control.exception;

public class PlayerNotExistsException extends CatanException {

    public PlayerNotExistsException(final String name) {
        super("Player " + name + " not exists");
    }

}
