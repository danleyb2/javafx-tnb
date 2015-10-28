package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by brian on 10/28/15
 * at 10 : 15 ,
 * working on JavaFx1.
 */
public class BindingExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Properties Binding");
        VBox vBox=new VBox();

        HBox hBox=new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        final StringProperty st=new SimpleStringProperty("Meters");

        ChoiceBox<String> state=new ChoiceBox<>();
        state.getItems().addAll("M to Km", "Km to M");
        state.setValue(state.getItems().get(0));
        state.getStyleClass().add("line");


        TextField textField=new TextField();
        textField.setPromptText("0");
        textField.setId("lifne");
        textField.getStyleClass().addAll("line");

        Label labelRslt=new Label();
        labelRslt.getStyleClass().addAll("line", "label-border");
        labelRslt.setId("labelRslt");

        Label labelUnits=new Label("Meters");
        labelUnits.getStyleClass().addAll("label-border", "line");
        labelUnits.setId("labelUnits");

        labelUnits.textProperty().bind(st);


        //trigger text change event
        state.getSelectionModel().selectedItemProperty().addListener(((observable1, oldValue1, newValue1) -> {
            //textField.setText(textField.getText()+" ");
            textField.appendText(" ");//this will just get trimmed away
            st.setValue(state.getSelectionModel().getSelectedIndex() == 0 ? "Meters" : "Kilometers");
        }));

        ObservableValue<String> vl = textField.textProperty();
        vl.addListener((observable, oldValue, newValue) -> {
            try {
                int n = Integer.parseInt(vl.getValue().trim());
                labelRslt.setText(String.valueOf(state.getSelectionModel().getSelectedIndex() == 0 ? mToKm(n) : kmTom(n)));
            } catch (NumberFormatException e) {
                if(textField.getText()=="")labelRslt.setText("Nan");
                System.out.println("Input digits");
            }

        });

        hBox.getChildren().addAll(state,textField, labelRslt,labelUnits);

        vBox.getChildren().addAll(hBox);
        Scene scene=new Scene(vBox,600,200);
        scene.getStylesheets().add("binding.css");

        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public int mToKm(int m){
        return m/1000;
    }
    public int kmTom(int km){
        return km*1000;
    }
    public static void main(String[] args){

        launch(args);
    }
}

