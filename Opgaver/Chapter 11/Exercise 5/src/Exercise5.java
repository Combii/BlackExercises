import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise5 {

    public static void main(String[] args) {

        int[] numbers = {7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9};

        List<Integer> intList = new LinkedList<>();

        addToList(numbers, intList);

        System.out.println(sortAndRemoveDuplicates(intList));

    }

    public static Set<Integer> sortAndRemoveDuplicates(List<Integer> list){
        Collections.sort(list);
        return new TreeSet<>(list);
    }

    public static void addToList(int[] numbers, List<Integer> list){
        for (int i : numbers) {
            list.add(i);
        }
    }

    }


