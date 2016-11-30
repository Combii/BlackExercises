import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise10 {

    public static void main(String[] args) {

        String[] numbers = {"317", "589369", "2113368", "96952705", "83646917", "31926046412"};

        Set<String> list = new HashSet<>();

        addToList(numbers, list);
        saveLength(list);
        removeOddLength(list);
        System.out.println(list);
    }

    public static void removeOddLength(Set<String> set){
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() % 2 != 0) {
                iterator.remove();
            }
        }
    }

    public static void saveLength(Set<String> set){

        List<Integer> counter = new ArrayList<>();

        for(String i : set){
            counter.add(i.length());
        }
        System.out.println(counter);
    }

    public static void addToList(String[] numbers, Set<String> list){
        Collections.addAll(list, numbers);
    }

    }


