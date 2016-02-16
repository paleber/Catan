package gui;

import com.google.inject.Inject;
import control.menu.IMenuSubject;
import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IView;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GuiMenuControl extends StackPane implements IMenuSubject {

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
    public void initialize(IMainControl cm, IView view) {
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
