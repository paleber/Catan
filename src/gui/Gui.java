package gui;

import com.google.inject.Inject;
import control.menu.MenuControl;
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


    @Inject
    private MenuPane menu;

    //@Inject
    //private GuiGameControl game;

    private final JFrame frame = new JFrame("SE-Project: Catan");

    @Override
    public void onInitialize(IMainControl mainControl) {
        LOGGER.trace("Initializing");

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainControl.shutdown();
            }
        });

        frame.setPreferredSize(new Dimension(MIN_HEIGHT, MIN_WIDTH));
        frame.pack();
        frame.setLocationRelativeTo(null);

        clearContent();

        frame.setVisible(true);


        mainControl.registerSubject(menu, MenuControl.class, this);

    }

    @Override
    public void onShutdown() {
        LOGGER.trace("Shutting down");
        frame.dispose();
    }

    void setContent(Container content) {
        frame.setContentPane(content);
        frame.revalidate();
    }

    void clearContent() {
        frame.setContentPane(new JPanel());
        frame.revalidate();
    }

}
