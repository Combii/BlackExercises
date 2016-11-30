package APresentationTier;

import BusinessLogic.Classes.GroceryCategory;

/**
 * Created by Combii on 15/08/16.
 */
public class RunProgram {

    public static void main(String[] args) {
            GroceryCategory groceryList = new GroceryCategory();

            System.out.print(groceryList);
            System.out.println(groceryList.getTotalCost());

    }

}
