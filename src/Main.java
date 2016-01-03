import control.MenuMainControl;
import engine.control.ControlManager;
import control.GameMainControl;
import gui.Gui;
import tui.Tui;

public class Main {

    public static void main(String[] args) {

        ControlManager cm = new ControlManager();

        new GameMainControl(cm);
        new MenuMainControl(cm);

        new Gui(cm);
        new Tui(cm);

        cm.switchControl(MenuMainControl.class);

        cm.shutdown(); // TODO entfernen
    }
}
