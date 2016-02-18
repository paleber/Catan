package engine.text_cmd.imp;

import com.google.inject.AbstractModule;
import engine.text_cmd.ITextCommandReader;

public final class TextCommandModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ITextCommandReader.class).to(TextCommandReader.class);
    }

}
