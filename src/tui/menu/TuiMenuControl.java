package tui.menu;

import control.IMenuControl;
import engine.control.IControlManager;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import engine.text_command.TextCommandReader;
import tui.common.CmdShutdown;

public final class TuiMenuControl implements IMenuControl {

    private static final Logger LOGGER = LogManager.getLogger();

    private TextCommandReader reader = new TextCommandReader();

    @Override
    public void initialize(IControlManager cm, IView view) {
        LOGGER.trace("Initializing");
        reader.addCommand("exit", new CmdShutdown(cm));
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        reader.start();
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        reader.stop();
    }

    @Override
    public void test() {
        System.out.println("testing tui menu Controller");
    }

}
