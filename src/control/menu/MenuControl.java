package control.menu;

import control.exception.*;
import control.exception.menu.IllegalNameException;
import control.exception.menu.IllegalNumberOfPlayersException;
import control.exception.menu.NameInUseException;
import control.exception.menu.PlayerNotExistsException;
import control.game.GameControl;
import engine.control.IMainControl;
import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public final class MenuControl implements IMenuObserver {

    private static final Logger LOGGER = LogManager.getLogger();

    private final List<IMenuSubject> subjects = new LinkedList<>();

    private PlayerData playerData;

    private IMainControl main;

    @Override
    public void onInitialize(IMainControl main) {
        LOGGER.trace("Initializing");
        this.main = main;
        playerData = main.getSharedData(PlayerData.class);
    }

    @Override
    public void onSubjectAdded(IMenuSubject subject) {
        subjects.add(subject);
    }

    @Override
    public void onStart() {
        LOGGER.trace("Starting");
        for (String playerName : playerData.getPlayerNames()) {
            for (IMenuSubject subject : subjects) {
                subject.onPlayerAdded(playerName);
            }
        }
    }

    @Override
    public void onStop() {
        LOGGER.trace("Stopping");
    }

    /*
    @Override
    public void setPlayerName(String name, int index) {
        playerData.setPlayerName(name, index);
        for(IMenuSubject subject: subjects) {
            subject.updatePlayerName(index, name);
        }
    } */

    /*
    @Override
    public void setNumberOfPlayers(int number) {
        playerData.setNumberOfPlayers(number);
        for(IMenuSubject subject: subjects) {
            subject.updatePlayerName(index, name);
        }
    } */

    @Override
    public void addPlayer(String name) throws NameInUseException,
            IllegalNameException, IllegalNumberOfPlayersException {
        playerData.addPlayer(name);
        for (IMenuSubject subject : subjects) {
            subject.onPlayerAdded(name);
        }
    }

    @Override
    public void removePlayer(String name) throws PlayerNotExistsException {
        playerData.removePlayer(name);
        for (IMenuSubject subject : subjects) {
            subject.onPlayerRemoved(name);
        }
    }

    @Override
    public void startGame() throws IllegalNumberOfPlayersException {
        playerData.checkStartConditions();
        main.switchControl(GameControl.class);
    }

}
