package MaxValue;

/**
 * Created by David Stovlbaek on 27/09/16.
 */
public class SumThread extends Thread {
    private int lo, hi;
    private int[] arr;
    public int ans = 0;

    public SumThread(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override
    public void run() {
        int maxValue = Integer.MIN_VALUE;
        for (int i = lo; i < hi; i++) {
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        ans = maxValue;
    }
}
