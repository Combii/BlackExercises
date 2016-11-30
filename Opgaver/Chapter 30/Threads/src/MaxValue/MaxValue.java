package MaxValue;

import java.util.Random;

/**
 * Created by David Stovlbaek on 27/09/16.
 */
public class MaxValue {

    public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[100];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(9000);
        }
        int sum = sum(arr);
        System.out.println("Sum: " + sum);
    }

    /**
     * Sum the elements of an array.
     *
     * @param arr array to sum
     * @return sum of the array's elements
     * @throws InterruptedException shouldn't happen
     */
    public static int sum(int[] arr) throws InterruptedException {
        int len = arr.length;
        int ans = 0;

        // Create and start 4 threads.
        SumThread[] ts = new SumThread[4];
        for (int i = 0; i < 4; i++) {
            ts[i] = new SumThread(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }

        // Wait for the threads to finish and sum their results.
        for (int i = 0; i < 4; i++) {
            ans = Integer.MIN_VALUE;
            ts[i].join();
            if(ans < ts[i].ans)
                ans = ts[i].ans;
        }
        return ans;
    }

}
