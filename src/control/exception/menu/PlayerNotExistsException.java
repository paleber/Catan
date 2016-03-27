package control.exception.menu;

import control.exception.CatanException;

public class PlayerNotExistsException extends CatanException {

    public PlayerNotExistsException(final String name) {
        super("Player " + name + " not exists");
    }

}
