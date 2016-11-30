import java.util.*;
import java.io.File;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise13 {

    public static void main(String[] args) {

        Map<String, String> words = new Hashtable<>();
        Map<String, String> words2 = new Hashtable<>();

        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 13/src/names.txt", words);
        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 13/src/names2.txt", words2);

        System.out.println(isUnique(words));
        System.out.println(isUnique(words2));
    }


    public static boolean isUnique(Map<String, String> map) {
        //I use HashTable since IntelliJ says HashMap is deprecated. What I read it should be the same thing.
        Map<String, Integer> wordCounts = new Hashtable<>();

        for(String s: map.keySet()){
        if(wordCounts.containsKey(s)){
            wordCounts.put(s, wordCounts.get(s) + 1);
        }
        else if(wordCounts.containsKey(map.get(s))){
            wordCounts.put(map.get(s), wordCounts.get(map.get(s)) + 1);
        }
        else{
            wordCounts.put(s, 1);
            wordCounts.put(map.get(s), 1);
        }
        }
        //printKeys(wordCounts);

        for (String key : wordCounts.keySet()) {
            if(wordCounts.get(key) != 1) return false;
        }
        return true;
    }

    public static boolean isUnique2(Map<String, String> map){

        List<String> surNames = new ArrayList<>(map.values());
        Set<String> noDuplicates = new HashSet<>(surNames);
        return surNames.size() == noDuplicates.size();
    }

    public static void addToList(String textFile, Map<String, String> map) {
        try{
            Scanner input = new Scanner(new File(textFile));
            while(input.hasNext()){
                map.put(input.next(), input.next());
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void printKeys(Map<String, Integer> map){
        for(String i : map.keySet()){
            System.out.println("Key: " + i + "\nValue: " + map.get(i) + "\n");
        }
    }
}


