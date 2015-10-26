package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by brian on 10/26/15.
 */
public class PropertiesEx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("String properties");
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

        primaryStage.setScene(new Scene(stackPane,200,400));
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
