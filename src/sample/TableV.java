package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by brian on 10/23/15.
 */
public class TableV extends Application {

    TableView<Product> tableView;

    public ObservableList<Product> getProduct(){
        ObservableList<Product> products= FXCollections.observableArrayList();
        products.add(new Product("Name one",788,1));
        products.add(new Product("Name Two",78,1));
        products.add(new Product("Name Three",254,7));
        products.add(new Product("Name Four",698,1));
        return products;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Table view");

        TableColumn<Product,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product,Integer> priceColumn=new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product,Integer> quantityColumn=new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tableView=new TableView<>();
        tableView.setItems(getProduct());
        tableView.getColumns().addAll(nameColumn,quantityColumn,priceColumn);


        VBox vBox=new VBox();
        vBox.getChildren().addAll(tableView);

        Scene scene=new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
