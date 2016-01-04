package control;

import engine.control.IControlManager;
import engine.control.imp.ControlManager;
import engine.control.IControl;
import engine.control.IMainControl;

import java.util.LinkedList;
import java.util.List;


public final class MenuMainControl implements IMainControl {

    private final List<IMenuControl> views = new LinkedList<>();

    private IControlManager controlManager;

    @Override
    public void initialize(IControlManager controlManager) {
        this.controlManager = controlManager;
        System.out.println("MenuMain init");
    }




    @Override
    public void addControl(IControl view) {
        assert (view instanceof IMenuControl);
        views.add((IMenuControl) view);
    }

    @Override
    public void start() {
        System.out.println("Starte MenuController");
        views.forEach(IMenuControl::start);
    }

    @Override
    public void stop() {
        views.forEach(IMenuControl::stop);
        System.out.println("Beende MenuController");
    }

}
