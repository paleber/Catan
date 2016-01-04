import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import control.GameMainControl;
import control.MenuMainControl;
import engine.console.imp.ConsoleModule;
import engine.control.IControlManager;
import engine.control.imp.ControlModule;
import geo.imp.GeoModule;
import gui.Gui;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private MenuMainControl menu;

    @Inject
    private GameMainControl game;

    @Inject
    private Tui tui;

    @Inject
    private Gui gui;

    private void initialize() {

        // TODO add shared Data

        controlManager.registerMainControl(menu);
        controlManager.registerMainControl(game);

        controlManager.registerView(tui);
        controlManager.registerView(gui);

        controlManager.switchControl(MenuMainControl.class);

        controlManager.shutdown();
    }

    public static void main(String[] args) {
        LogManager.getLogger();
        Catan catan = INJECTOR.getInstance(Catan.class);
        catan.initialize();
    }

}
