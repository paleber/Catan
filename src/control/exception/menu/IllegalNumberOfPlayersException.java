package control.exception.menu;

import control.exception.CatanException;

public final class IllegalNumberOfPlayersException extends CatanException {

    public IllegalNumberOfPlayersException(int min, int max) {
        super("Only " + min + " to " + max + " players allowed");
    }

}
