package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product{
    private String name;
    private int price;
    private int quantity;

    private StringProperty productCode=new SimpleStringProperty(this,"productCode","");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    Product(){
        this.name="";
        this.price=0;

        this.quantity=0;
    }
    Product(String name,int quantity,int price){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public String getProductCode() {
        return productCode.get();
    }

    public StringProperty productCodeProperty() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode.set(productCode);
    }
}
