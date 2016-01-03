package tui;

import engine.control.imp.ControlManager;
import control.GameMainControl;
import engine.control.IControl;

public final class TuiGameControl implements IControl {

    public TuiGameControl(ControlManager cm, Tui tui) {
        cm.registerViewControl(this, GameMainControl.class);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
