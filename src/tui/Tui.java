package tui;

import com.google.inject.Inject;
import control.game.GameControl;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.IView;
import engine.text_cmd.ITextCommand;
import engine.text_cmd.ITextCommandReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.common.CmdShutdown;
import tui.game.TuiGameControl;
import tui.menu.TuiMenuSubject;


public final class Tui implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    private ITextCommandReader textCommandReader;

    @Inject
    private TuiMenuSubject menu;

    @Inject
    private TuiGameControl game;

    private CmdShutdown cmdShutdown;

    @Override
    public void onInitialize(final IMainControl mainControl) {
        LOGGER.trace("Initializing");

        mainControl.registerSubject(menu, MenuControl.class, this);
        mainControl.registerSubject(game, GameControl.class, this);

        cmdShutdown = new CmdShutdown(mainControl);
        
        textCommandReader.start();
    }

    public void addCommand(String name, ITextCommand cmd) {
        textCommandReader.addCommand(name, cmd);
    }

    public void clearCommands() {
        textCommandReader.clearCommands();
        textCommandReader.addCommand("exit", cmdShutdown);
    }

    @Override
    public void onShutdown() {
        LOGGER.trace("Shutting down");
        textCommandReader.shutdown();
    }

}
