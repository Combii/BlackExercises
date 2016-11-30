import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise11 {

    public static void main(String[] args) {

        Integer[] numbers = {1, 4, 7, 9};
        Integer[] numbers2 = {2, 4, 5, 6, 7};

        Set<Integer> list = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();

        addToList(numbers, list);
        addToList(numbers2, list2);

        System.out.println(symmetricSetDifference(list, list2));
    }


    public static Set<Integer> symmetricSetDifference(Set<Integer> s1, Set<Integer> s2) {

        Set<Integer> newSet = new HashSet<>();

        for(Integer i : s1){
            if(!s2.contains(i)){
            newSet.add(i);
            }
        }
        for(Integer i : s2){
            if(!s1.contains(i)){
                newSet.add(i);
            }
        }
        return newSet;
    }

    public static void addToList(Integer[] numbers, Set<Integer> list) {
        Collections.addAll(list, numbers);


    }
}


