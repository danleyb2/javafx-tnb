package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application{


    public Button button;
    Stage window;
    Scene scene1,scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window=primaryStage;
        window.setTitle("Scene Switch");
        window.setOnCloseRequest(event -> {
            event.consume();
            closeWindow();
        });
        Label label1=new Label("Scene one");
        button=new Button();
        button.setText("Go to Scene Two");
        button.setOnAction(e -> {
            //handle event
            window.setScene(scene2);
        });
        Button buttonAlert=new Button("Alert");
        buttonAlert.setOnAction(e -> AlertBox.display("Alert Title", "Alert Message"));

        Button buttonConfirm=new Button("Confirm Box");
        buttonConfirm.setOnAction(e -> {
            boolean choice = ConfirmBox.display("Confirm Title", "Confirm Message");
            AlertBox.display("Choice was ", choice ? "Yes" : "No");
        });

        VBox menuLeft=new VBox(20);
        HBox topMenu=new HBox();
        topMenu.getChildren().addAll(buttonAlert,buttonConfirm);
        menuLeft.getChildren().add(button);
        StackPane center=new StackPane();
        center.getChildren().add(label1);

        Label label=new Label("Scene Two");
        Button button2=new Button("Go to scene One");
        button2.setOnAction(e -> {
            //handle event
            window.setScene(scene1);
        });
        VBox layout=new VBox();
        layout.getChildren().addAll(label,button2);
        scene2=new Scene(layout,400,500);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(menuLeft);
        borderPane.setCenter(center);
        scene1=new Scene(borderPane,400,500);
        window.setScene(scene1);
        window.show();
    }

    public void closeWindow(){
        //save files before close

        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
