package gui;

import control.menu.IMenuSubject;
import engine.control.IMainControl;
import engine.control.IView;
import javafx.scene.layout.StackPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GuiMenuControl extends StackPane implements IMenuSubject<Gui> {

    private static final Logger LOGGER = LogManager.getLogger();

   // private Gui gui;

    /*
    public GuiMenuControl() {
        /*assert (view instanceof Gui);
        gui = (Gui) view;
        gui.setPane(this); *

        Button bn = new Button("Start Game");

        bn.setOnAction(event -> System.out.println("dsfgfd"));

        Circle c = new Circle(40, 40, 30);
        getChildren().add(c);
        getChildren().add(bn);
    } */

    @Override
    public void initialize(IMainControl cm, Gui gui) {
        LOGGER.trace("Initializing");




    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
    }

    @Override
    public void updatePlayerNames(String names) {

    }
}
