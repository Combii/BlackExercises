package MyQuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by David Stovlbaek on 17/10/16.
 */
public class MyQuickSortOptimized {

    public static void myQuickSort(int[] list) {
        myQuickSort(list, 0, list.length-1);
    }

    private static void myQuickSort(int[] list, int first, int last){
        if(last < 0) return;
        int pivotIndex = pivot(list, first ,last);
        if(first > pivotIndex) return;
        myQuickSort(list, first, (pivotIndex - 1)/2);
        myQuickSort(list, (pivotIndex + 1)/2, last);
    }

    private static int pivot(int[] list, int firstIndex, int lastIndex){
        return MyQuickSort.pivot(list, firstIndex, lastIndex);
    }

}
