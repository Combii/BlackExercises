import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise9 {

    public static void main(String[] args) {

        Integer[] numbers = {1, 23, 3, 7, 43, 9, 1, 3, 17, 8};

        Set<Integer> list = new HashSet<>();

        addToList(numbers, list);
        System.out.println(hasEven(list));
    }

    public static boolean hasEven(Set<Integer> set){
        for (Integer i : set) {
            if((i%2)==0){
                return true;
            }
        }
    return false;
    }

    public static void addToList(Integer[] numbers, Set<Integer> list){
        Collections.addAll(list, numbers);
    }

    }


