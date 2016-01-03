package engine.console.imp;

import com.google.inject.AbstractModule;
import engine.console.IConsole;

public class ConsoleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IConsole.class).to(Console.class);
    }

}
