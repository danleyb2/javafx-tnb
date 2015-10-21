package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

        ChoiceBox<String> choiceBox=new ChoiceBox<>();
        choiceBox.getItems().add("Value one");
        choiceBox.getItems().add("Value Two");
        choiceBox.getItems().addAll("Value Three", "Value Four");
        choiceBox.setValue(choiceBox.getItems().get(0));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
            System.out.println("Change from "+oldValue+" to "+newValue);
        });


        Button button=new Button("Click");
        button.setOnAction(event -> {
            System.out.println(checkBox.isSelected()?"Choice A selected":"Choice A not selected");
            System.out.println(choiceBox.getValue());
        });

        VBox vBox=new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(checkBox,checkBox1,checkBox2,choiceBox,button);


        Scene scene=new Scene(vBox,300,500);
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
