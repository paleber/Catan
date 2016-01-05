package tui;

import com.google.inject.Inject;
import control.GameMainControl;
import control.MenuMainControl;
import engine.control.IControlManager;
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
    public void initialize(final IControlManager cm) {
        LOGGER.trace("Initializing");
        cm.registerControl(menu, MenuMainControl.class, this);
        cm.registerControl(game, GameMainControl.class, this);
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
    }

}
