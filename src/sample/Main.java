package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>{


    public Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World");
        button=new Button();
        button.setText("Click");
        button.setOnAction(this);
        StackPane layout=new StackPane();
        layout.getChildren().add(button);
        Scene scene=new Scene(layout,400,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("An event occured");
        if (event.getSource()==button){
            //do smt for button
            System.out.println("A button was clicked");
        }

    }
}
