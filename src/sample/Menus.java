package sample;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by brian on 10/23/15.
 */
public class Menus extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Making menus");
        Menu menu=new Menu("_File");
        menu.getItems().add(new MenuItem("New"));
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Exit"));

        Menu menu1=new Menu("Help");
        CheckMenuItem checkMenuItem1=new CheckMenuItem("Autosave");
        checkMenuItem1.setSelected(true);
        CheckMenuItem checkMenuItem=new CheckMenuItem("Show view");
        checkMenuItem.setOnAction(event -> {
            if (checkMenuItem.isSelected()) {
                System.out.println("Check menu item selected");
            }
        });


        ToggleGroup difficulty=new ToggleGroup();
        RadioMenuItem easy=new RadioMenuItem("Easy");
        RadioMenuItem hard=new RadioMenuItem("Hard");
        RadioMenuItem medium=new RadioMenuItem("Medium");

        easy.setSelected(true);

        easy.setToggleGroup(difficulty);
        medium.setToggleGroup(difficulty);
        hard.setToggleGroup(difficulty);

        menu1.getItems().addAll(checkMenuItem, checkMenuItem1, easy, medium, hard);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(menu, menu1);

        BorderPane borderPane=new BorderPane();
        borderPane.setStyle("-fx-background-color: aqua");
        borderPane.setTop(menuBar);
        Scene scene=new Scene(borderPane,400,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
