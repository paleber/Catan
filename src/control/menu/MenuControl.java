package control.menu;

import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IControlSubject;
import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public final class MenuControl implements IControlObserver {

    private static final Logger LOGGER = LogManager.getLogger();

    private final List<IMenuSubject> views = new LinkedList<>();

    private PlayerData playerData;

    @Override
    public void initialize(IMainControl cm) {
        LOGGER.trace("Initializing");
        playerData = (PlayerData) cm.getSharedData(PlayerData.class);
    }

    @Override
    public void addSubject(IControlSubject view) {
        assert (view instanceof IMenuSubject);
        views.add((IMenuSubject) view);
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        views.forEach(IMenuSubject::start);
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        views.forEach(IMenuSubject::stop);
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
