package sample;

public class Product{
    private String name;
    private int price;
    private int quantity;

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
}
