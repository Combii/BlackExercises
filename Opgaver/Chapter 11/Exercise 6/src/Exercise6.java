import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise6 {

    public static void main(String[] args) {

        int[] numbers = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};

        List<Integer> intList = new LinkedList<>();

        addToList(numbers, intList);

        System.out.println(countUnique(intList));
    }

    public static int countUnique(List<Integer> list){
        return new HashSet<>(list).size();
    }

    public static void addToList(int[] numbers, List<Integer> list){
        for (int i : numbers) {
            list.add(i);
        }
    }

    }


