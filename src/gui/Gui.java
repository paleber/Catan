package gui;

import com.google.inject.Inject;
import engine.control.IMainControl;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public final class Gui implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int MIN_WIDTH = 400;
    private static final int MIN_HEIGHT = 300;

    private IMainControl mainControl;

    @Inject
    private MenuPane menu;

    //@Inject
    //private GuiGameControl game;

    private final JFrame frame = new JFrame("SE-Project: Catan");

    @Override
    public void initialize(IMainControl main) {
        LOGGER.trace("Initializing");
        main.registerView(this);
        menu.initialize(main, this);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                main.shutdown();
            }
        });

        frame.setPreferredSize(new Dimension(MIN_HEIGHT, MIN_WIDTH));
        frame.pack();
        frame.setLocationRelativeTo(null);

        clearContent();

        frame.setVisible(true);
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
        frame.dispose();
    }

    public void setContent(Container content) {
        frame.setContentPane(content);
        frame.revalidate();
    }

    public void clearContent() {
        frame.setContentPane(new JPanel());
        frame.revalidate();
    }

}
