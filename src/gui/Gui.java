package gui;

import engine.control.imp.ControlManager;
import engine.control.IView;

public final class Gui implements IView {

    public Gui(ControlManager cm) {
        System.out.println("<Gui constructor>");
    }

    @Override
    public void onInitialize() {
        System.out.println("Gui initialize");
    }

    @Override
    public void onShutdown() {
        System.out.println("Gui shutdown");
    }
}