package gui;

import com.google.inject.Inject;
import control.game.GameControl;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Gui implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    private GuiMenuControl menu;

    @Inject
    private GuiGameControl game;

    @Override
    public void initialize(IMainControl cm) {
        LOGGER.trace("Initializing");
        cm.addSubject(menu, MenuControl.class, this);
        cm.addSubject(game, GameControl.class, this);
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
    }

}
