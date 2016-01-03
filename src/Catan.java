import com.google.inject.Guice;
import com.google.inject.Injector;
import control.MenuMainControl;
import engine.console.imp.ConsoleModule;
import engine.control.imp.ControlManager;
import control.GameMainControl;
import geo.imp.GeoModule;
import gui.Gui;
import tui.Tui;

public class Catan {

    public static void main(final String[] args) {

        Injector injector = Guice.createInjector(
                new GeoModule(),
                new ConsoleModule()
        );




    }

    private Catan() {
        ControlManager cm = new ControlManager();

        new GameMainControl(cm);
        new MenuMainControl(cm);

        new Gui(cm);
        new Tui(cm);

        cm.switchControl(MenuMainControl.class);

        cm.shutdown(); // TODO entfernen
    }

}
