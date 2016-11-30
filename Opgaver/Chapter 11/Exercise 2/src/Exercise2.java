import java.util.LinkedList;
import java.util.List;
/**
 * Created by Combii on 18/08/16.
 */
public class Exercise2 {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};
        int[] numbers2 = {6, 7, 8, 9, 10, 11, 12};


        List<Integer> intList1 = new LinkedList<>();
        List<Integer> intList2 = new LinkedList<>();

        addToList(numbers, intList1);
        addToList(numbers2, intList2);

        System.out.println(intList1 + "\n" + intList2);

        System.out.println(alternate(intList1, intList2));
        System.out.println(System.currentTimeMillis());
    }

    public static List<Integer> alternate(List<Integer> list1, List<Integer> list2){
        List<Integer> newList = new LinkedList<>();

        int list1Length = list1.size();
        int list2Length = list2.size();

        for(int i = 0; i < Math.max(list1.size(),list2.size()); i++){
            if(list1Length > i) {
                newList.add(list1.get(i));
            }
            if(list2Length > i) {
                newList.add(list2.get(i));
            }
        }
        return newList;
    }

    public static void addToList(int[] numbers, List<Integer> list){
        for (int i : numbers) {
            list.add(i);
        }
    }
}

