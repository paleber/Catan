import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import control.GameControl;
import control.MenuControl;
import engine.console.imp.ConsoleModule;
import engine.control.IControlManager;
import engine.control.imp.ControlModule;
import geo.imp.GeoModule;
import gui.Gui;
import model.common.PlayerData;
import tui.Tui;

public final class Catan {

    private static final Injector INJECTOR = Guice.createInjector(
            new ControlModule(),
            new GeoModule(),
            new ConsoleModule()
    );

    @Inject
    private IControlManager controlManager;

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

        controlManager.addSharedData(playerData);

        controlManager.registerMainControl(menu);
        controlManager.registerMainControl(game);

        controlManager.registerView(tui);
        controlManager.registerView(gui);

        controlManager.switchControl(MenuControl.class);
    }

    public static void main(String[] args) {
        Catan catan = INJECTOR.getInstance(Catan.class);
        catan.initialize();
    }

}
