import MergeSort.MergeSort;
import MergeSort.MergeSortThread;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by David Stovlbaek on 11/10/16.
 */
public class Sort{

    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        E temp;
        int counter = list.length;
        while(counter != 0) {
            for (int i = 0; i < counter; i++) {
                try {
                    if (list[i].compareTo(list[i + 1]) == 1) {
                        temp = list[i];
                        list[i] = list[i + 1];
                        list[i + 1] = temp;
                    }
                } catch (Exception e) {
                }
            }
            counter--;
        }
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator){
        E temp;
        int counter = list.length;
        while(counter != 0) {
            for (int i = 0; i < counter; i++) {
                try {
                    if (comparator.compare(list[i], list[i + 1]) == 1) {
                        temp = list[i];
                        list[i] = list[i + 1];
                        list[i + 1] = temp;
                    }
                } catch (Exception ignored) {
                }
            }
            counter--;
        }
    }


    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
                quickSort(list, first, pivotIndex - 1);
                quickSort(list, pivotIndex + 1, last);
        }
    }

    /** Partition the array list[first..last] Backup*//*
    private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && (list[low].compareTo(pivot) == -1 || list[low].compareTo(pivot) == 0))
                low++;

            // Search backward from right
            while (low <= high && list[high].compareTo(pivot) == 1)
                high--;

            // Swap two elements in the list
            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && (list[high].compareTo(pivot) == 1 || list[high].compareTo(pivot) == 0))
            high--;

        // Swap pivot with list[high]
        if (pivot.compareTo(list[high]) == 1) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else
            return first;
    }
    */

    private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && (list[low].compareTo(pivot) == -1 || list[low].compareTo(pivot) == 0))
                low++;

            // Search backward from right
            while (low <= high && list[high].compareTo(pivot) == 1)
                high--;

            // Swap two elements in the list
            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && (list[high].compareTo(pivot) == 1 || list[high].compareTo(pivot) == 0))
            high--;

        // Swap pivot with list[high]
        if (pivot.compareTo(list[high]) == 1) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else
            return first;
    }




    public static <E extends Comparable<E>> void mergeSortThread(E[] list){
        MergeSort.mergeSort(list);
    }

    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            E[] firstHalf = (E[]) new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) new Comparable[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /** Merge two sorted lists */
    public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp){
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
