package sample;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by brian on 10/26/15
 * at 10 : 12 ,
 * working on JavaFx1.
 */
public class PropertiesEx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("String and Integer properties");
        IntegerProperty x=new SimpleIntegerProperty(5);
        IntegerProperty y=new SimpleIntegerProperty();

        y.bind(x.multiply(2));

        System.out.println("y: " + y.getValue());

        x.setValue(4);

        System.out.println("y: " + y.getValue());

        Product product=new Product();
        product.productCodeProperty().addListener((o, oldV, newV) -> {
            System.out.println("Product code change event... ");
            System.out.println("oldV = " + oldV);
            System.out.println("newV = " + newV);
        });

        Button button=new Button("Change Prop");
        button.setOnAction(event -> product.setProductCode("newPCode"));
        StackPane stackPane=new StackPane();
        stackPane.getChildren().add(button);

        primaryStage.setScene(new Scene(stackPane,300,400));
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
