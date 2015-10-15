package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{


    public Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello World");
        button=new Button();
        button.setText("Click");
        button.setOnAction(e -> {
            //handle event
            System.out.println("Event using lambda expression");
        });
        StackPane layout=new StackPane();
        layout.getChildren().add(button);
        Scene scene=new Scene(layout,400,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
