package tui;

import control.IMenuControl;
import control.MenuMainControl;
import engine.control.IControlManager;
import engine.control.IView;
import engine.control.imp.ControlManager;

public final class TuiMenuControl implements IMenuControl {


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
        System.out.println("testing tui menu Controller");
    }
}
