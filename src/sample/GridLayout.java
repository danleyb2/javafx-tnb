package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



/**
 * Created by brian on 10/19/15.
 */
public class GridLayout extends Application{
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Grid Layout");
        GridPane grid=new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label label=new Label("Username");
        GridPane.setConstraints(label, 0, 0);

        TextField textField=new TextField("Field");
        GridPane.setConstraints(textField, 1, 0);

        Label label1=new Label("password");
        GridPane.setConstraints(label1, 0, 1);

        TextField textField2=new TextField();
        textField2.setPromptText("Password");
        GridPane.setConstraints(textField2, 1, 1);

        Button login=new Button("Log in");
        GridPane.setConstraints(login,1,2);

        grid.getChildren().addAll(label, textField, label1, textField2, login);

        Scene scene=new Scene(grid,300,200);
        window.setScene(scene);
        window.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
