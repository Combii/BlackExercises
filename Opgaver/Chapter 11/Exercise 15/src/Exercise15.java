import java.util.*;
import java.io.File;

/**
 * Created by David Stovlbaek on 18/08/16.
 */
public class Exercise15 {

    public static void main(String[] args) {

        Integer[] numbers = {15, 1, 6, 12, -3, 4, 8, 21, 2, 30, -1, 9};

        List<Integer> list = new LinkedList<>();
        addToList(numbers, list);

        System.out.println(maxOccurrences(list));
    }


    public static String maxOccurrences(List<Integer> list) {
        if(list.isEmpty()){
            return "0";
        }
        //I use HashTable since IntelliJ says HashMap is deprecated. What I read it should be the same thing.
        Map<Integer, Integer> numberCounter = new Hashtable<>();
        int max, maxNumber = 0;

        for(Integer i: list){
            if(numberCounter.containsKey(i)){
                numberCounter.put(i, numberCounter.get(i) + 1);
            }
            else{
                numberCounter.put(i, 1);
            }
        }
        //printKeys(numberCounter);

        max = Collections.max(numberCounter.values());

        //Couldn't find .getKey() had to make my own loop
        for(Integer i : numberCounter.keySet()){
            if(numberCounter.get(i) == max){
                maxNumber = i;
            }
        }

        return "Most frequently occurring Integer: " + maxNumber + "\nNumber occurs: " + max + " times";
    }



    public static void printKeys(Map<Integer, Integer> map){
        for(Integer i : map.keySet()){
            System.out.println("Key: " + i + "\nValue: " + map.get(i) + "\n");
        }
    }

    public static void addToList(Integer[] numbers, List<Integer> list){
        Collections.addAll(list, numbers);
    }
}


