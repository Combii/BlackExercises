import java.util.*;

/**
 * Created by Combii on 18/08/16.
 */
public class Exercise3 {

    public static void main(String[] args) {

        int[] numbers = {1, 1, 2, 0, 4, 5, 6, 8, 8, 3, 11, 9, 12, 0, 14, 0, 16};

        List<Integer> intList = new LinkedList<>();

        addToList(numbers, intList);

        System.out.println(removeEvenInRange(intList, 5, 13));

    }

    public static List<Integer> removeEvenInRange(List<Integer> list, int start, int end){
        Integer[] arrNumber = convertToArray(list);

        for (int i = start; i < end; i++){
            if((arrNumber[i]%2)==0){
                arrNumber[i] = null;
            }
        }

        List<Integer> newIntList = new LinkedList<>();

        for (Integer anArrNumber : arrNumber) {
            if (anArrNumber != null) {
                newIntList.add(anArrNumber);
            }
        }
        return newIntList;
    }

    public static void addToList(int[] numbers, List<Integer> list){
        for (int i : numbers) {
            list.add(i);
        }
    }

    public static Integer[] convertToArray(List<Integer> list){
         Integer[] ret = new Integer[list.size()];
            for(int i = 0;i < ret.length;i++)
                ret[i] = list.get(i);
            return ret;
        }

    }


