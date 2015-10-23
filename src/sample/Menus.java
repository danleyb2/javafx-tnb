package sample;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by brian on 10/23/15.
 */
public class Menus extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Making menus");
        Menu menu=new Menu("File");
        menu.getItems().add(new MenuItem("New"));
        menu.getItems().add(new MenuItem("Exit"));

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().add(menu);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(menuBar);
        Scene scene=new Scene(borderPane,400,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
