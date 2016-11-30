import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by David Stovlbaek on 24/09/16.
 */
public class RunProgram {

    public static void main(String[] args) {
        //MyQueue<Integer> testQueue = new LinkedListGeneric<Integer>();
        MyQueue<Integer> testerList = new MyArrayListGeneric<Integer>();

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        testerList.push(1);
        testerList.push(2);
        testerList.push(3);


        System.out.println("TesterList " + testerList);
        System.out.println();

        System.out.println("Pop: " + testerList.pop());
    }
}
