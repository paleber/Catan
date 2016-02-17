package control.menu;

import engine.control.IMainControl;
import engine.control.IControlObserver;
import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public final class MenuControl implements IControlObserver<IMenuSubject> {

    private static final Logger LOGGER = LogManager.getLogger();

    private final List<IMenuSubject> subjects = new LinkedList<>();

    private PlayerData playerData;



    @Override
    public void initialize(IMainControl cm) {
        LOGGER.trace("Initializing");
        cm.registerObserver(this);
        playerData = (PlayerData) cm.getSharedData(PlayerData.class);
    }

    @Override
    public void addSubject(IMenuSubject subject) {
        subjects.add(subject);
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        subjects.forEach(IMenuSubject::start);
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        subjects.forEach(IMenuSubject::stop);
    }

    public void setNumberPlayer(int n)  {
        playerData.setNumberPlayers(n);
    }

    public void setPlayerName(String name, int index) {
        playerData.setPlayerName(name, index);
    }

    public String[] getPlayerNames() {
        return playerData.getPlayerNames();
    }

}
