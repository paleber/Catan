package tui;

import com.google.inject.Inject;
import engine.control.IMainControl;
import engine.control.IView;
import engine.text_cmd.ITextCommand;
import engine.text_cmd.ITextCommandReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.game.TuiGameControl;
import tui.menu.TuiMenuControl;


public final class Tui implements IView, ITextCommandReader {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    private ITextCommandReader textCommandReader;

    @Inject
    private TuiMenuControl menu;

    @Inject
    private TuiGameControl game;

    @Override
    public void initialize(final IMainControl mainControl) {
        LOGGER.trace("Initializing");

        mainControl.registerView(this);
        menu.initialize(mainControl, this);
        game.initialize(mainControl, this);

        //cm.addSubject(menu, MenuControl.class, this);
        //cm.addSubject(game, GameControl.class, this);
        //cm.registerSubject(game, GameControl.class);
    }



    @Override
    public void addCommand(String name, ITextCommand cmd) {
        textCommandReader.addCommand(name, cmd);
    }

    @Override
    public void clearCommands() {
        textCommandReader.clearCommands();
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
        textCommandReader.shutdown();
    }

}
