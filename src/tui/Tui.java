package tui;

import com.google.inject.Inject;
import control.GameMainControl;
import control.MenuMainControl;
import engine.console.IConsole;
import engine.control.IControlManager;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Tui implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    private TuiMenuControl menu;

    @Inject
    private TuiGameControl game;

    @Inject
    private IConsole console;

    @Override
    public void initialize(IControlManager cm) {
        LOGGER.info("Initializing");
        cm.registerControl(menu, MenuMainControl.class, this);
        cm.registerControl(game, GameMainControl.class, this);
    }

    @Override
    public void shutdown() {
        LOGGER.info("Shutting down");
    }

    public IConsole getConsole() {
        return console;
    }

}