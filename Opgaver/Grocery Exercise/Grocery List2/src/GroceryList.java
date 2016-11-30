/**
 * Created by Combii on 15/08/16.
 */

import java.util.*;

public class GroceryList {

    private ArrayList<GroceryItemOrder> groceryItems = new ArrayList<>();
    private String groceryCategory = "";

    public GroceryList(String groceryCategory) {
        this.groceryCategory = groceryCategory;
    }

    //--------------------------Getter-------------------------------
    public ArrayList<GroceryItemOrder> getGroceryItems() {
        return groceryItems;
    }

    public String getGroceryCategory() {
        return groceryCategory;
    }
    //----------------------------------------------------------------

    public void addGrocery(String name, double price, int quantity){

        groceryItems.add(new GroceryItemOrder(name, price, quantity));
    }

    @Override
    public String toString() {
        String rString = groceryCategory + ":\n\n";
           for(GroceryItemOrder i : groceryItems) {
               rString += i.toString() + "\n\n";
           }
        return rString;
    }
}

