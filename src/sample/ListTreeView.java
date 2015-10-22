package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by brian on 10/22/15.
 */
public class ListTreeView extends Application {

    ListView<String> listView;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("List view example");
        Button button=new Button("Submit");
        listView=new ListView<>();
        listView.getItems().addAll("list item 1","list item 2","list item 3","list item 4");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox vBox=new VBox(5);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(listView,button);

        button.setOnAction(event -> {
            ObservableList<String> items=listView.getSelectionModel().getSelectedItems();
            for (String f:items){
                System.out.println(f);
            }
        });


        Scene scene=new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
