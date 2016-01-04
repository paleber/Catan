package tui;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import control.MenuMainControl;
import engine.control.IControlManager;
import engine.control.imp.ControlManager;
import engine.control.IView;

public final class Tui implements IView {

    @Inject
    private TuiMenuControl menu;

    @Override
    public void initialize(IControlManager cm) {
        System.out.println("-->> Tui initialize");
        cm.registerControl(menu, MenuMainControl.class, this);
    }

    @Override
    public void shutdown() {
        System.out.println("Tui shutdown");
    }

}