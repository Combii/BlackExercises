import java.util.*;
import java.io.File;

/**
 * Created by David Stovlbaek on 18/08/16.
 */
public class Exercise16 {

    public static void main(String[] args) {

        Map<String, String> nameList = new Hashtable<>();
        Map<String, String> nameList2 = new Hashtable<>();

        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 16/src/names.txt", nameList);
        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 16/src/names2.txt", nameList2);

        //printKeys(nameList);
        System.out.println(is1to1(nameList));
        System.out.println(is1to1(nameList2));
    }


    public static boolean is1to1(Map<String, String> map) {
        if(map.isEmpty()){
            return true;
        }
        List<String> counter = new LinkedList<>();

        for (String i : map.keySet()){
            if(counter.contains(i) || counter.contains(map.get(i))){
                return false;
            }
            else{
                counter.add(i);
                counter.add(map.get(i));
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


