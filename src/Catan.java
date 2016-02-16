import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import control.game.GameControl;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.imp.ControlModule;
import geo.imp.GeoModule;
import gui.Gui;
import gui.MyApp;
import javafx.application.Application;
import model.common.PlayerData;
import tui.Tui;

public final class Catan {

    private static final Injector INJECTOR = Guice.createInjector(
            new ControlModule(),
            new GeoModule()
    );

    @Inject
    private IMainControl mainControl;

    @Inject
    private MenuControl menu;

    @Inject
    private GameControl game;

    @Inject
    private Tui tui;

    @Inject
    private Gui gui;

    @Inject
    private PlayerData playerData;

    private void initialize() {
        mainControl.addSharedData(playerData);

        menu.initialize(mainControl);
        game.initialize(mainControl);

        tui.initialize(mainControl);
        gui.initialize(mainControl);

        mainControl.switchControl(MenuControl.class);
    }

    public static void main(String[] args) {
        Catan catan = INJECTOR.getInstance(Catan.class);
        catan.initialize();
    }

}
