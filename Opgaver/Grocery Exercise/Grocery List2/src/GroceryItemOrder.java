/**
 * Created by Combii on 15/08/16.
 */

import java.text.DecimalFormat;

public class GroceryItemOrder {

    private String name;
    private int quantity;
    private double price;

    public GroceryItemOrder(String name, double price, int quantity) {
        try {
            if (quantity == 0) {
                throw new Exception();
            }
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }
        catch(Exception e){
            System.out.println("Quantity of " + name + " can't be zero");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceTotal() {
        return price*quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        DecimalFormat decFor = new DecimalFormat("#.##");

        if(quantity > 1){
            return "Item: " + name + "\n" + "Price: " + decFor.format(price) + " Kr\nQuantity: " + quantity + "\nPrice Combined: " + decFor.format(price*quantity) + " Kr";
        }
        return "Item: " + name + "\n" + "Price: " + decFor.format(price) + " Kr\nQuantity: " + quantity;
    }
}
