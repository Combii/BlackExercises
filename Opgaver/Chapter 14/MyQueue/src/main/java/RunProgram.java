import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by David Stovlbaek on 24/09/16.
 */
public class RunProgram {

    public static void main(String[] args) {
        MyList<Integer> testQueue = new LinkedListGeneric<Integer>();
        Queue<Integer> list = new LinkedList<Integer>();



        testQueue.add(1);
        testQueue.add(2);
        testQueue.add(3);

        for (int i : testQueue){
            System.out.print(i + " ");
        }


       // System.out.println(testQueue);

    }
}
