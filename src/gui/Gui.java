package gui;

import engine.control.IControlManager;
import engine.control.imp.ControlManager;
import engine.control.IView;

public final class Gui implements IView {

    @Override
    public void initialize(IControlManager cm) {
        System.out.println("Gui initialize");
    }

    @Override
    public void shutdown() {
        System.out.println("Gui shutdown");
    }
}