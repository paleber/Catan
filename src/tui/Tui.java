package tui;

import com.google.inject.Inject;
import control.MenuMainControl;
import engine.console.IConsole;
import engine.control.IControlManager;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Tui implements IView {

    private static final Logger LOGGER = LogManager.getLogger(Tui.class);

    @Inject
    private TuiMenuControl menu;

    @Inject
    private IConsole console;

    @Override
    public void initialize(IControlManager cm) {
        LOGGER.info("Initializing Tui");
        cm.registerControl(menu, MenuMainControl.class, this);
    }

    @Override
    public void shutdown() {
        System.out.println("Tui shutdown");
    }

    public IConsole getConsole() {
        return console;
    }




}