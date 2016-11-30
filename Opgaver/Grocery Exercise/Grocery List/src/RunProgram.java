/**
 * Created by Combii on 15/08/16.
 */
public class RunProgram {

    public static void main(String[] args) {
    try {
        GroceryCategory groceryList = new GroceryCategory();

        groceryList.addGroceryItem("Food Items", "Apple", 1, 2);
        groceryList.addGroceryItem("Food Items", "Banana", 2, 6);
        groceryList.addGroceryItem("Electronics", "PC", 2000, 1);

        System.out.print(groceryList);
        System.out.println(groceryList.getTotalCost());


    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
}
