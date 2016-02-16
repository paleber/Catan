package gui;

import engine.control.IControlObserver;
import engine.control.IControlSubject;
import engine.control.IMainControl;
import engine.control.IView;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MenuPane extends StackPane implements IControlSubject{

    private static final Logger LOGGER = LogManager.getLogger();

    private Gui gui;

    @Override
    public void initialize(IMainControl cm, IView view) {
        LOGGER.trace("Initializing");
        assert (view instanceof Gui);
        gui = (Gui) view;
        gui.setPane(this);

        Button bn = new Button("Start Game");

        bn.setOnAction(event -> System.out.println("dsfgfd"));

        Circle c = new Circle(40, 40, 30);
        getChildren().add(c);
        getChildren().add(bn);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

}
