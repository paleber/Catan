package engine.control.imp;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import engine.control.IMainControl;

public class ControlModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IMainControl.class).to(MainControl.class).in(Singleton.class);
    }

}
