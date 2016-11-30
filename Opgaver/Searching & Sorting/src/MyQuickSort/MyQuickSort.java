package MyQuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by David Stovlbaek on 17/10/16.
 */
public class MyQuickSort {

    public static void myQuickSort(int[] list) {
        myQuickSort(list, 0, list.length-1);
    }

    private static void myQuickSort(int[] list, int first, int last){
        if(last < 0) return;
        int pivotIndex = pivot(list, first ,last);
        if(first > pivotIndex) return;
        myQuickSort(list, first, pivotIndex - 1);
        myQuickSort(list, pivotIndex + 1, last);
    }

    public static int pivot(int[] list, int firstIndex, int lastIndex){

        int pivot = list[lastIndex];
        int pivotIndex = lastIndex;

        int i = firstIndex-1;

        int j = firstIndex;

        while (j < lastIndex && i < lastIndex) {
            while (j < lastIndex && pivot < list[j]) {
                j++;
            }

            i++;

            if(j > i) {
                int temp = list[j];
                list[j] = list[i];
                list[i] = temp;
                pivotIndex = i;
            }
            else
                j++;

        }
        if(j < lastIndex && i == 0){
            list[lastIndex] = list[i];
            list[i] = pivot;
            return i;
        }
        else if(i < lastIndex && j < lastIndex){
            list[lastIndex] = list[i + 1];
            list[i + 1] = pivot;
            return i+1;
        }
        return pivotIndex;
    }

}
