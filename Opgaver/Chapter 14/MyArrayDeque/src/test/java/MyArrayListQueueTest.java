import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by David Stovlbaek on 26/09/16.
 */
public class MyArrayListQueueTest {

    static MyQueue<Integer> testerList;
    static ArrayList<Integer> savedList;

    @Before
    public void setUp() throws Exception {
        testerList = new MyArrayListGeneric<Integer>();
        savedList = new ArrayList<Integer>();

        Random r = new Random();

        for(int i = 0; i < 100; i++){
            int number = r.nextInt(999);
            testerList.add(number);
            savedList.add(number);
        }
    }

    @Test
    public void poll() throws Exception {
        for(int i = 0; i < savedList.size(); i++) {
            assertEquals(savedList.get(i), testerList.poll());
            assertEquals(savedList.size()-(i+1), testerList.size());
        }
    }

    @Test
    public void remove() throws Exception {
        for(int i = 0; i < savedList.size(); i++) {
            testerList.remove();
            assertEquals(savedList.size()-(i+1), testerList.size());
        }
    }

    @Test
    public void peek() throws Exception {
        for(int i = 0; i < savedList.size(); i++) {
            assertEquals(savedList.get(i), testerList.peek());
            testerList.remove();
        }
    }


}