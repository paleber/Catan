package control.exception.menu;

import control.exception.CatanException;

public class NameInUseException extends CatanException {

    public NameInUseException(final String name) {
        super("Name already in use: " + name);
    }

}
