import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Combii on 16/08/16.
 */
public class GroceryCategory {
    private static ArrayList<GroceryList> groceryList = new ArrayList<>();

    public void addGroceryItem(String category, String name, double price, int quantity){
        checkItemsMaxAllowed();

        for (GroceryList i : groceryList) {
            if(i.getGroceryCategory().toLowerCase().equals(category.toLowerCase())) {
                i.addGrocery(name, price, quantity);
                return;
            }
        }
        GroceryList newGroceryList = new GroceryList(category);

        newGroceryList.addGrocery(name, price, quantity);

        groceryList.add(newGroceryList);
    }

    public String getTotalCost(){
        DecimalFormat decFor = new DecimalFormat("#.##");

        double totalPrice = 0;
        for (GroceryList i : groceryList){
            for(GroceryItemOrder k : i.getGroceryItems()){
                totalPrice += k.getPriceTotal();
            }
        }
        return "Total Price: " + decFor.format(totalPrice) + " Kr";
    }

    private void checkItemsMaxAllowed(){
        int total = 0;
            for (GroceryList i : groceryList) {
                total += i.getGroceryItems().size();
            }
            if (total >= 10) {
                System.out.println("Item list can't exceed 10");
                return;
        }
    }

    @Override
    public String toString() {
        String rString = "";

        for (GroceryList i : groceryList){
            rString += i.toString() + "\n";
        }
        return rString;
    }
}
