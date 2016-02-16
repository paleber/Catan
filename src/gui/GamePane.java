package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class GamePane extends StackPane {

    public GamePane() {
        Label lb = new Label("Game running");
        getChildren().add(lb);
    }
    
}