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
import tui.game.TuiGameControl;
import tui.menu.TuiMenuControl;


public final class Tui implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    private ITextCommandReader textCommandReader;

    @Inject
    private TuiMenuControl menu;

    @Inject
    private TuiGameControl game;

    @Override
    public void onInitialize(final IMainControl mainControl) {
        LOGGER.trace("Initializing");

        mainControl.registerSubject(menu);
        mainControl.registerSubject(game);


        textCommandReader.start();
        //cm.onSubjectAdded(menu, MenuControl.class, this);
        //cm.onSubjectAdded(game, GameControl.class, this);
        //cm.registerSubject(game, GameControl.class);
    }

    public void addCommand(String name, ITextCommand cmd) {
        textCommandReader.addCommand(name, cmd);
    }

    public void clearCommands() {
        textCommandReader.clearCommands();
    }

    @Override
    public void onShutdown() {
        LOGGER.trace("Shutting down");
        textCommandReader.shutdown();
    }

}
