package gui;

import com.google.inject.Inject;
import control.game.GameControl;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.IView;
import javafx.application.Application;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Gui extends Application implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int MIN_WIDTH = 400;
    private static final int MIN_HEIGHT = 300;

    @Inject
    private GuiMenuControl menu;

    @Inject
    private GuiGameControl game;

    @Override
    public void initialize(IMainControl main) {
        LOGGER.trace("Initializing");

        main.registerView(this);

        menu.initialize(main, this);
        game.initialize(main, this);

        new Thread(() -> {
            Application.launch(Gui.class);
        }).start();
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
    }


    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.trace("Start Application");
        this.stage = stage;






        stage.setTitle("SE-Project: Catan");


        stage.setScene(new Scene(new StackPane()));

        stage.setHeight(MIN_HEIGHT);
        stage.setWidth(MIN_WIDTH);


        //stage.getScene().setRoot(root);
        stage.show();




    }

    private Stage stage;


    public void setPane(final StackPane pane) {

        while (stage == null) {
            try {
                Thread.sleep(200);
                LOGGER.debug("Sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(stage.getScene() == null) {
            stage.setScene(new Scene(pane));
            System.out.println(stage == null);
            stage.show();
        } else {
            stage.getScene().setRoot(pane);
        }
    }

}
