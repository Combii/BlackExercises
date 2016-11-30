import java.util.*;
import java.io.File;

/**
 * Created by David Stovlbaek on 18/08/16.
 */
public class Exercise14 {

    public static void main(String[] args) {

        Map<String, Integer> words = new Hashtable<>();
        Map<String, Integer> words2 = new Hashtable<>();

        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 14/src/names.txt", words);
        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 14/src/names2.txt", words2);

        printKeys(intersect(words, words2));
    }


    public static Map<String, Integer> intersect(Map<String, Integer> map, Map<String, Integer> map2) {
        //I use HashTable since IntelliJ says HashMap is deprecated. What I read it should be the same thing.
        Map<String, Integer> newMap = new Hashtable<>();

        for (String s : map.keySet()) {
            if (map2.containsKey(s) && map2.get(s).equals(map.get(s))) {
               // if (map2.get(s).equals(map.get(s))) {
                    newMap.put(s, map.get(s));
               // }
            }
        }
        return newMap;
    }


    public static void addToList(String textFile, Map<String, Integer> map) {
        try{
            Scanner input = new Scanner(new File(textFile));
            while(input.hasNext()){
                map.put(input.next(), Integer.parseInt(input.next()));
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


