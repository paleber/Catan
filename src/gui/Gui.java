package gui;

import com.google.inject.Injector;
import engine.control.IMainControl;
import engine.control.IView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// stellt das Fenster dar
public final class Gui extends Application implements IView {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int MIN_WIDTH = 400;
    private static final int MIN_HEIGHT = 300;

    private IMainControl mainControl;

    //@Inject
    private GuiMenuControl menu;

    //@Inject
    private GuiGameControl game;

    @Override
    public void initialize(IMainControl main) {
        LOGGER.trace("Initializing");

        main.registerView(this);

        menu.initialize(main, this);
        game.initialize(main, this);

        //this.stage = stage;

        stage.setTitle("SE-Project: Catan");

        scene = new Scene(new StackPane());
        LOGGER.debug("In Start: " + scene == null);

        stage.setScene(scene);

        stage.setHeight(MIN_HEIGHT);
        stage.setWidth(MIN_WIDTH);

        //stage.getScene().setRoot(root);
        LOGGER.debug("In Start: " + scene == null);
        stage.show();
        LOGGER.debug("In Start: " + scene == null);

    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
    }

    private static volatile Gui instance;

    private Stage stage;

    public static Gui create(Injector injector) {
        new Thread(() -> {
            launch();
        }).start();

        // Wait for launch
        while (instance == null) {
            Thread.yield();
        }

        instance.menu = injector.getInstance(GuiMenuControl.class);
        instance.game = injector.getInstance(GuiGameControl.class);
        return instance;
        /*
        while (true) {
            synchronized (instance) {
                if (instance != null) {
                    return instance;
                }
            }
            Thread.yield();
        } */
    }

    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.trace("Start Application");
        this.stage = stage;
        //synchronized (instance) {
            instance = this;
        //}
    }

    private volatile Scene scene; // TODO replace with LoadPane ???

    public void setPane(final StackPane pane) {

        LOGGER.debug("In setPane: " + scene == null);

        while (scene == null) {
            try {
                Thread.sleep(200);
                LOGGER.debug("Sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*
        while (stage == null) {
            try {
                Thread.sleep(200);
                LOGGER.debug("Sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } */

        /*
        if(stage.getScene() == null) {
            stage.setScene(new Scene(pane));
            System.out.println(stage == null);
            stage.show();
        } else {
            stage.getScene().setRoot(pane);
        } */
        scene.setRoot(pane);
    }

}
