package MergeSort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by David Stovlbaek on 13/10/16.
 */
public class MergeSort{

    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> void mergeSort(E[] list){
        
        E[] firstHalf = (E[]) new Comparable[list.length / 2];
        System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

        int secondHalfLength = list.length - list.length / 2;
        E[] secondHalf = (E[]) new Comparable[secondHalfLength];
        System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);


        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<E[]> task1 = service.submit(new MergeSortThread<>(firstHalf));
        Future<E[]> task2 = service.submit(new MergeSortThread<>(secondHalf));

        E[] list1 = null;
        E[] list2 = null;

        try {
            // waits the 10 seconds for the Callable.call to finish.
            list1 = task1.get(); // this raises ExecutionException if thread dies
            list2 = task2.get();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        service.shutdownNow();
        try {
            merge(list1, list2, list);
        }
        catch (Exception e){
            System.out.println("Null");
        }
    }

    private static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp){
        int current1 = 0; //Current index in list1
        int current2 = 0; //Current index in list2
        int current3 = 0; //Current index in list3

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) == -1)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
}
