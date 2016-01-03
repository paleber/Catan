package tui;

import engine.control.imp.ControlManager;
import engine.control.IView;

public final class Tui implements IView {

    public Tui(ControlManager cm) {
        System.out.println("<Tui constructor>");
        cm.registerView(this);
        new TuiMenuControl(cm, this);
        new TuiGameControl(cm, this);
    }

    @Override
    public void onInitialize() {
        System.out.println("Tui initialize");
    }

    @Override
    public void onShutdown() {
        System.out.println("Tui shutdown");
    }
}