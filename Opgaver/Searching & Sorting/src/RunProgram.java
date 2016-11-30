import MyQuickSort.MyQuickSort;
import QuickSort.NewQuickSort;

import java.util.*;

/**
 * Created by David Stovlbaek on 12/10/16.
 */
    public class RunProgram{

    //Default class "Package-private"
    static class MyComparator<T extends Comparable<T>> implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
            //return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
        }
    }



    public static void main(String[] args) {

        int[] list = new int[20000000];
       // ArrayList<Integer> list2 = new ArrayList<>();

        /*
        list[0] = 2;
        list[1] = 6;
        list[2] = 4;
        list[3] = 9;
        list[4] = 10;
        list[5] = 1;
        list[6] = 7;
        list[7] = 3;
        list[8] = 5;
        list[9] = 8;
        */
        
        Random r = new Random();

        for(int i = 0; i < list.length; i++){
            list[i] = r.nextInt(10000);
            //list2.add(r.nextInt(10000));
        }
        /*
        System.out.println("Start!");
        long startTimer = System.currentTimeMillis();

        //System.out.println(Arrays.toString(list));
        //Sort.mergeSort2(list);
        Collections.sort(list2);
        //System.out.println(Arrays.toString(list));
        long doneTimer = System.currentTimeMillis();
        System.out.println("Done sorted!");
        System.out.println("Time: " + (doneTimer-startTimer));
        */


        System.out.println("Start!");
        long startTimer = System.currentTimeMillis();
        //System.out.println(Arrays.toString(list));
        MyQuickSort.myQuickSort(list);
        //System.out.println(Arrays.toString(list));
        long doneTimer = System.currentTimeMillis();
        System.out.println("Done sorted!");
        System.out.println("Time: " + (doneTimer-startTimer));

    }


}
