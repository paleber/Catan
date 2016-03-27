package control.menu;

import control.exception.menu.IllegalNameException;
import control.exception.menu.IllegalNumberOfPlayersException;
import control.exception.menu.NameInUseException;
import control.exception.menu.PlayerNotExistsException;
import engine.control.IControlObserver;

public interface IMenuObserver extends IControlObserver<IMenuSubject> {

    void addPlayer(String name) throws NameInUseException, IllegalNameException, IllegalNumberOfPlayersException;

    void removePlayer(String name) throws PlayerNotExistsException;

    void startGame() throws IllegalNumberOfPlayersException;

}
