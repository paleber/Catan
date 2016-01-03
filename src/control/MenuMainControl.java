package control;

import engine.control.ControlManager;
import engine.control.IControl;
import engine.control.IMainControl;

import java.util.LinkedList;
import java.util.List;


public final class MenuMainControl implements IMainControl {

    private final List<IMenuControl> views = new LinkedList<>();

    public MenuMainControl(ControlManager cm) {
        cm.registerMainControl(this);
    }

    @Override
    public void addView(IControl view) {
        assert (view instanceof IMenuControl);
        views.add((IMenuControl) view);
    }

    @Override
    public void onStart() {
        System.out.println("Starte MenuController");
        views.forEach(IMenuControl::onStart);
    }

    @Override
    public void onStop() {
        views.forEach(IMenuControl::onStop);
        System.out.println("Beende MenuController");
    }

}
