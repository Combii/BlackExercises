import java.util.Scanner;

/**
 * Created by Combii on 15/08/16.
 */
public class RunProgram {

    public static void main(String[] args) {
        try {
            GroceryCategory groceryList = new GroceryCategory();

            groceryList.addGroceryItem("Food Items", "Banana", 2, 2);
            groceryList.addGroceryItem("Food Items", "Banana", 2, 6);
            groceryList.addGroceryItem("Electronics", "PC", 2000, 1);
            groceryList.addGroceryItem("Electronics", "PC", 2000, 1);

            //groceryList.removeGroceryItem("Banana", 2, 2);

            //addItem(groceryList);

            System.out.print(groceryList);
            System.out.println(groceryList.getTotalCost());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
}
