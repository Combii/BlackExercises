package BusinessLogic.Interfaces;

import BusinessLogic.Classes.GroceryList;

import java.util.ArrayList;

/**
 * Created by David Stovlbaek on 23/10/2016.
 */
public interface GroceryCategoryInterface {

    ArrayList<GroceryList> groceryList = new ArrayList<>();

    void addGroceryItem(String category, String name, double price, int quantity);

    void removeGroceryItem(String name, double price, int quantity);

    String getTotalCost();

    String toString();

}
