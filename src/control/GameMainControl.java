package control;

import engine.control.IControlManager;
import engine.control.imp.ControlManager;
import engine.control.IControl;
import engine.control.IMainControl;

public final class GameMainControl implements IMainControl{

    private IControlManager controlManager;

    @Override
    public void initialize(IControlManager controlManager) {
        this.controlManager = controlManager;
    }

    @Override
    public void addControl(IControl view) {

    }



    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

}
