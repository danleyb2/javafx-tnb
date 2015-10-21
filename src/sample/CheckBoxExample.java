package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

/**
 * Created by brian on 10/21/15.
 */
public class CheckBoxExample extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("CheckBox");

        CheckBox checkBox=new CheckBox("Choice A");
        CheckBox checkBox1=new CheckBox("Choice B");
        checkBox1.setSelected(true);
        checkBox.setOnAction(event1 -> {
            System.out.println("Event on CheckBox A");
        });
        CheckBox checkBox2=new CheckBox("Choice C");

        Button button=new Button("Click");
        button.setOnAction(event -> {
            System.out.println(checkBox.isSelected()?"Choice A selected":"Choice A not selected");
            checkBox.isSelected();
            checkBox.isSelected();
        });

        VBox vBox=new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(checkBox,checkBox1,checkBox2,button);


        Scene scene=new Scene(vBox,300,500);
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
