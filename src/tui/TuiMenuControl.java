package tui;

import control.IMenuControl;
import control.MenuMainControl;
import engine.control.ControlManager;

public final class TuiMenuControl implements IMenuControl {

    public TuiMenuControl(ControlManager cm, Tui tui) {
        cm.registerViewControl(this, MenuMainControl.class);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void test() {
        System.out.println("testing tui menu Controller");
    }
}
