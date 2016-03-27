package control.game;

import engine.control.IMainControl;
import model.common.PlayerData;
import model.game.IIntersection;
import model.game.IPath;
import model.game.IPlayer;
import model.game.ITerrain;
import model.game.event.IGameEvent;
import model.game.object.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public final class GameControl implements IGameControl {

    private static final Logger LOGGER = LogManager.getLogger();

    private IMainControl mainControl;

    private final List<IGameSubject> subjects = new LinkedList<>();


    Game game;

    @Override
    public void onInitialize(IMainControl mainControl) {
        LOGGER.trace("Initializing");
        this.mainControl = mainControl;

    }

    @Override
    public void onSubjectAdded(IGameSubject subject) {
        subjects.add(subject);
    }

    @Override
    public void onStart() {
        LOGGER.trace("Starting");
        game = new Game(this, mainControl.getSharedData(PlayerData.class).getPlayerNames());
    }

    @Override
    public void onStop() {
        LOGGER.trace("Stopping");
    }

    @Override
    public void sendGameEvent(IGameEvent event) {

    }
}
