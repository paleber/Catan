package control.menu;

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

    @Override
    public void initialize(IMainControl main) {
        LOGGER.trace("Initializing");
        main.registerObserver(this);
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


        // TODO Subjects auf neusten Stand bringen

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
    public void addPlayer(String name) {
        playerData.addPlayer(name);
        for(IMenuSubject subject: subjects) {
            subject.onPlayerAdded(name);
        }
    }

    @Override
    public void removePlayer(String name) {
        playerData.removePlayer(name);
        for(IMenuSubject subject: subjects) {
            subject.onPlayerRemoved(name);
        }
    }
}
