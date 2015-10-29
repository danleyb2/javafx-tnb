package fxmlExample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by brian on 10/29/15
 * at 21 : 19 ,
 * working on JavaFx1.
 */
public class FxmlExample extends Application {
    public static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent parent= FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(parent));
        window=primaryStage;
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
