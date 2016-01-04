package gui;


import control.IMenuControl;
import engine.control.IControlManager;
import engine.control.IView;

public final class GuiMenuControl implements IMenuControl {

    @Override
    public void initialize(IControlManager cm, IView view) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void test() {
        System.out.println("testing Gui menu Controller");
    }
}
