import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise7 {

    public static void main(String[] args) {

        int[] numbers = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
        int[] numbers2 = {-5, 15, 2, -1, 7, 15, 36};

        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();


        addToList(numbers, list);
        addToList(numbers2, list2);

        System.out.println(countCommon(list, list2));
    }

    public static int countCommon(List<Integer> list, List<Integer> list2){
        Set<Integer> rSet = new HashSet<>();

        for (Integer i : list) {
            if(list2.contains(i)){
                rSet.add(i);
            }
        }
        return rSet.size();
    }

    public static void addToList(int[] numbers, List<Integer> list){
        for (int i : numbers) {
            list.add(i);
        }
    }

    }


