package sample;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title,String message){
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(200);
        Label label=new Label(message);

        Button btn1=new Button("YES"),btn2=new Button("NO");

        btn1.setOnAction(e -> {
            answer=true;
            stage.close();
        });
        btn2.setOnAction(e->{
            answer=false;
            stage.close();
        });

        VBox vBox=new VBox(10);
        vBox.getChildren().addAll(label,btn1,btn2);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();

        return answer;

    }
}
