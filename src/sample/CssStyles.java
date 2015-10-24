package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by brian on 10/24/15.
 */
public class CssStyles extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CSS styles themes");
        VBox vBox=new VBox();
        HBox hBox=new HBox();

        Label label=new Label("Username");
        label.setStyle("-fx-text-fill: blue;-fx-font-size: 18px");
        TextField textField=new TextField();
        textField.getStyleClass().add("custom-css");
        textField.setId("id-css");
        hBox.getChildren().addAll(label,textField);

        vBox.getChildren().addAll(hBox);

        Scene scene=new Scene(vBox,400,300);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
