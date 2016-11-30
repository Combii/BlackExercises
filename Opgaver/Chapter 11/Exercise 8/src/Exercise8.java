import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise8 {

    public static void main(String[] args) {

        String[] strings = {"Arie", "Charisse", "Velvet", "Nathanial", "Annmarie"};

        Set<String> list = new HashSet<>();

        addToList(strings, list);

        System.out.println(minLength(list));
    }

    public static int minLength(Set<String> set){
        int min = Integer.MAX_VALUE;

        for (String i : set) {
            if(i.length() < min){
                min = i.length();
            }
        }
        return min;
    }

    public static void addToList(String[] numbers, Set<String> list){
        Collections.addAll(list, numbers);
    }

    }


