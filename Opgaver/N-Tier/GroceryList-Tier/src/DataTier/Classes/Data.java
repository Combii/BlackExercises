package DataTier.Classes;

import BusinessLogic.Classes.GroceryCategory;
import DataTier.Interfaces.DataInterface;

import java.util.Scanner;

/**
 * Created by David Stovlbaek on 18/10/16.
 */
public class Data implements DataInterface {
    //Could have this package as text document and then this class got from text document and saved into text document

    public static void addItem(GroceryCategory groceryList) {

        String name, category;
        int quantity;
        double price;

        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("Write the category of the item:");
                category = input.nextLine();

                System.out.println("Write the item name you wish to add:");
                name = input.nextLine();

                System.out.println("Write the price of the item:");
                price = input.nextDouble();

                System.out.println("Write the quantity of the item:");
                quantity = input.nextInt();

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again");
            }
        }
        groceryList.addGroceryItem(category, name, price, quantity);
    }

    public static GroceryCategory getItems(){
        GroceryCategory groceryList = new GroceryCategory();

        groceryList.addGroceryItem("Food Items", "Banana", 2, 2);
        groceryList.addGroceryItem("Food Items", "Banana", 2, 6);
        groceryList.addGroceryItem("Electronics", "PC", 2000, 1);
        groceryList.addGroceryItem("Electronics", "PC", 2000, 1);
        return groceryList;
    }
}
