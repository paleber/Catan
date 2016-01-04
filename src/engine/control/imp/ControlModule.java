package engine.control.imp;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import engine.control.IControlManager;

public class ControlModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IControlManager.class).to(ControlManager.class).in(Singleton.class);
    }

}
