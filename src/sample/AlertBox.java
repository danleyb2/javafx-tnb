package sample;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {
    public static void display(String title,String message){
        Stage window=new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label=new Label();
        label.setText(message);
        Button closeButton=new Button("Close");
        closeButton.setOnAction(event -> {
            window.close();
        });

        VBox vBox=new VBox(10);
        vBox.getChildren().addAll(closeButton,label);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
    }
}
