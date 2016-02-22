package gui;

import control.menu.IMenuSubject;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.IView;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
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

    private MenuControl observer;
    private Gui gui;

    @Override
    public void initialize(IMainControl mainControl, Gui gui) {
        LOGGER.trace("Initializing");
        this.gui = gui;
        observer = mainControl.getObserver(MenuControl.class);
        observer.addSubject(this);
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");

        gui.setPane(this);

        Button bn = new Button("Start Game");

        bn.setOnAction(event -> System.out.println("Testausgabe"));

        Circle c = new Circle(40, 40, 30);
        getChildren().add(c);
        getChildren().add(bn);
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
    }


    @Override
    public void updateNumberOfPlayers(int number) {

    }

    @Override
    public void updatePlayerName(int index, String name) {

    }
}
