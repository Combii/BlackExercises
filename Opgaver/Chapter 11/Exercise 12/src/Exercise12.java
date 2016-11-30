import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise12 {

    public static void main(String[] args) {

        String[] letters = {"France", "Russia", "Russia", "Russia", "France", "Denmark", "Denmark", "Denmark", "France"};

        List<String> list = new ArrayList<>();

        addToList(letters, list);

        System.out.println(contains3(list));
    }


    public static boolean contains3(List<String> sList) {
        //I use HashTable since IntelliJ says HashMap is deprecated. What I read it should be the same thing.
        Hashtable<String, Integer> wordCounts = new Hashtable<>();

        for(String s: sList){
        if(wordCounts.containsKey(s)){
            wordCounts.put(s, wordCounts.get(s) + 1);
        }
        else{
            wordCounts.put(s, 1);
        }
        }

        for (String key : wordCounts.keySet()) {
            if(wordCounts.get(key) != 3) return false;
        }
        return true;
    }

    public static void addToList(String[] numbers, List<String> list) {
        Collections.addAll(list, numbers);


    }
}


