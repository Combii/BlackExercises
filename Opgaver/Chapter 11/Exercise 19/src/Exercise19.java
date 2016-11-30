import java.util.*;
import java.io.File;

/**
 * Created by David Stovlbaek on 18/08/16.
 */
public class Exercise19 {

    private static Map<Integer, Integer> map;

    public static void main(String[] args) {

        Map<String, Integer> nameList = new Hashtable<>();

        addToList("/Users/Combii/Dropbox/Datamatiker/2. Semester/Opgaver/Chapter 11/Exercise 19/src/numbers.txt", nameList);
        //printKeys(nameList);
        System.out.println();
        System.out.println(rarest(nameList));
    }


    public static String rarest(Map<String, Integer> map) {
        try {
            int min = Integer.MAX_VALUE, value = Integer.MAX_VALUE;

            if(map.isEmpty()){
                throw new Exception("HashTable is Empty");
            }
            Map<Integer, Integer> counter = new Hashtable<>();

            for(Integer i: map.values()){
                if(counter.containsKey(i)){
                    counter.put(i, counter.get(i) + 1);
                }
                else{
                    counter.put(i, 1);
                }
            }
            printKeys(counter);

            for(Integer i : counter.keySet()){
                if(min >= counter.get(i)){
                    min = counter.get(i);
                    value = Math.min(i, value);
                }
            }
            if(min <= 1){
                return value + " is the most rarest appearing: " + min + " time";
            }
            return value + " is the most rarest appearing: " + min + " times";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "0";
    }


   /*
   Found on the internet. Very advanced.

   public static void printMap(Map map) {
        for (Object o : map.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
    */

    public static void printKeys(Map<?, ?> map){
        for(Object i : map.keySet()){
            System.out.println(i + " = " + map.get(i));
        }
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

}


