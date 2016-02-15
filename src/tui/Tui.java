package tui;

import com.google.inject.Inject;
import control.game.GameControl;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.game.TuiGameControl;
import tui.menu.TuiMenuControl;


public final class Tui implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    private TuiMenuControl menu;

    @Inject
    private TuiGameControl game;

    @Override
    public void initialize(final IMainControl cm) {
        LOGGER.trace("Initializing");
        cm.addSubject(menu, MenuControl.class, this);
        cm.addSubject(game, GameControl.class, this);
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
    }

}
