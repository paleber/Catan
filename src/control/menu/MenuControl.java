package control.menu;

import control.exception.IllegalNameException;
import control.exception.IllegalNumberOfPlayersException;
import control.exception.NameInUseException;
import control.exception.PlayerNotExistsException;
import control.game.GameControl;
import engine.control.IMainControl;
import engine.control.IControlObserver;
import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.Subject;
import java.util.LinkedList;
import java.util.List;

public final class MenuControl implements IMenuObserver {

    private static final Logger LOGGER = LogManager.getLogger();

    private final List<IMenuSubject> subjects = new LinkedList<>();

    private PlayerData playerData;

    private IMainControl main;

    @Override
    public void initialize(IMainControl main) {
        LOGGER.trace("Initializing");
        main.registerObserver(this);
        this.main = main;
        playerData = main.getSharedData(PlayerData.class);
    }

    @Override
    public void addSubject(IMenuSubject subject) {
        subjects.add(subject);
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        subjects.forEach(IMenuSubject::start);
        for (String playerName : playerData.getPlayerNames()) {
            for (IMenuSubject subject : subjects) {
                subject.onPlayerAdded(playerName);
            }
        }
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        subjects.forEach(IMenuSubject::stop);
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
