import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise4 {

    public static void main(String[] args) {

        int[] numbers = {15, 1, 6, 12, -3, 4, 8, 21, 2, 30, -1, 9};

        List<Integer> intList = new LinkedList<>();

        addToList(numbers, intList);

        System.out.println(partition(intList, 5));

    }

    public static List<Integer> partition(List<Integer> list, int value){

        List<Integer> newList = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();


        for(Integer i : list){
            if(i < value) {
                newList.add(i);
            }
            else{
                tempList.add(i);
            }
        }
        newList.addAll(tempList);

        return newList;
    }

    public static void addToList(int[] numbers, List<Integer> list){
        for (int i : numbers) {
            list.add(i);
        }
    }

    }


