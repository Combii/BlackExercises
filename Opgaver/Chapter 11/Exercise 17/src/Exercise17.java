import java.util.*;
import java.io.File;

/**
 * Created by David Stovlbaek on 18/08/16.
 */
public class Exercise17 {

    public static void main(String[] args) {

        Map<String, String> nameList = new Hashtable<>();
        Map<String, String> nameList2 = new Hashtable<>();

        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 17/src/names.txt", nameList);
        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 17/src/names2.txt", nameList2);

        System.out.println(subMap(nameList, nameList2));
    }


    public static boolean subMap(Map<String, String> map, Map<String, String> map2) {
        for(String i : map.keySet()){
            if(map2.containsKey(i)){
                if(!map2.get(i).equals(map.get(i))){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
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


