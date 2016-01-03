package control;

import engine.control.ControlManager;
import engine.control.IControl;
import engine.control.IMainControl;

public final class GameMainControl implements IMainControl{

    public GameMainControl(ControlManager cm) {
        cm.registerMainControl(this);
    }

    @Override
    public void addView(IControl view) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

}
