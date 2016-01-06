package control;

import engine.control.IControlManager;
import engine.control.IControl;
import engine.control.IMainControl;
import model.common.CatanException;
import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

import static model.common.CatanException.*;

public final class MenuMainControl implements IMainControl {

    private static final Logger LOGGER = LogManager.getLogger();

    private final List<IMenuControl> views = new LinkedList<>();

    private PlayerData playerData;

    @Override
    public void initialize(IControlManager cm) {
        LOGGER.trace("Initializing");
        playerData = (PlayerData) cm.getSharedData(PlayerData.class);
    }

    @Override
    public void addControl(IControl view) {
        assert (view instanceof IMenuControl);
        views.add((IMenuControl) view);
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        views.forEach(IMenuControl::start);
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        views.forEach(IMenuControl::stop);
    }

    public void setNumberPlayer(int n) throws IllegalPlayerNumberException {
        playerData.setNumberPlayers(n);
    }

    public void setPlayerName(String name, int index)
            throws IllegalNameException, NameAlreadyInUseException, PlayerNotExistsException {
        playerData.setPlayerName(name, index);
    }

    public String[] getPlayerNames() {
        return playerData.getPlayerNames();
    }

}
