import java.util.*;
import java.io.File;

/**
 * Created by David Stovlbaek on 18/08/16.
 */
public class Exercise18 {

    public static void main(String[] args) {

        Map<String, String> nameList = new Hashtable<>();

        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 18/src/names.txt", nameList);

        printKeys(reverse(nameList));
    }


    public static Map<String, String> reverse(Map<String, String> map) {

        Map<String, String> newMap = new Hashtable<>();

        for(String i : map.keySet()){
            if(newMap.containsKey(map.get(i))) {
                newMap.put(map.get(i), newMap.get(map.get(i)) + ", " + i);
            }
            else{
               newMap.put(map.get(i), i);
            }
        }
        for(String i : newMap.keySet()){
            newMap.put(i, "[" + newMap.get(i) + "]");
        }

        return newMap;
    }



    public static void printKeys(Map<String, String> map){
        for(String i : map.keySet()){
            System.out.println("Key: " + i + "\nValue: " + map.get(i) + "\n");
        }
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
    }}


