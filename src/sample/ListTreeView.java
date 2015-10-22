package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by brian on 10/22/15.
 */
public class ListTreeView extends Application {

    ListView<String> listView;
    TreeView<String> treeView;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("List and Tree view");

        Button button=new Button("Submit");
        Button buttonS=new Button("TreeView");

        listView=new ListView<>();
        listView.getItems().addAll("list item 1", "list item 2", "list item 3", "list item 4");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox vBox=new VBox(5);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(listView, button, buttonS);

        button.setOnAction(event -> {
            ObservableList<String> items = listView.getSelectionModel().getSelectedItems();
            for (String f : items) {
                System.out.println(f);
            }
        });

        TreeItem<String> one,two,three;

        one=new TreeItem<>();
        one.setExpanded(true);

        two=makeBranch("Brian",one);
        makeBranch("Brian2", two);
        makeBranch("Brian2",two);

        three=makeBranch("Denis",one);
        makeBranch("Denis2",three);
        makeBranch("Denis2",three);

        treeView=new TreeView<>(one);
        treeView.setShowRoot(false);
        treeView.getSelectionModel()
                .selectedItemProperty()
                .addListener((v,oldV,newV)->{
                    System.out.println(newV!=null?newV.getValue():"");
                });

        StackPane stackPane=new StackPane();
        stackPane.getChildren().add(treeView);

        Scene scene=new Scene(vBox, 300, 300);
        Scene sceneTree=new Scene(stackPane, 300, 300);
        buttonS.setOnAction(event -> {
            if (primaryStage.getScene().equals(scene)){
                buttonS.setText("List View");
                stackPane.getChildren().add(buttonS);
                primaryStage.setScene(sceneTree);
            }else{
                vBox.getChildren().add(buttonS);
                buttonS.setText("Tree View");
                primaryStage.setScene(scene);
            }

        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public TreeItem<String> makeBranch(String title,TreeItem<String> parent){
        TreeItem<String> item=new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
    public static void main(String[] args){
        launch(args);
    }
}
