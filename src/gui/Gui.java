package gui;

import com.google.inject.Inject;
import control.GameControl;
import control.MenuControl;
import engine.control.IControlManager;
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
    public void initialize(IControlManager cm) {
        LOGGER.trace("Initializing");
        cm.registerControl(menu, MenuControl.class, this);
        cm.registerControl(game, GameControl.class, this);
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
    }

}
