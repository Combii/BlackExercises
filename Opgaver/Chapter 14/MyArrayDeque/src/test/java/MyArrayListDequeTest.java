import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * Created by David Stovlbaek on 26/09/16.
 */
public class MyArrayListDequeTest {

    static MyDeque<Integer> testerList;
    static ArrayList<Integer> savedList;

    @Before
    public void setUp() throws Exception {
            testerList = new MyArrayListGeneric<Integer>();
            savedList = new ArrayList<Integer>();

            Random r = new Random();

            for (int i = 0; i < 100; i++) {
                int number = r.nextInt(999);
                testerList.addLast(number);
                savedList.add(number);
            }
        }

    @Test
    public void addFirstAndPollFirst() throws Exception {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        Random r = new Random();

        for(int i = 0; i < 100; i++){
            int number = r.nextInt(999);
            testerList.addFirst(number);
            tempList.add(number);
        }

        for(int i = tempList.size()-1; i >= 0; i--){
            assertEquals(tempList.get(i), testerList.pollFirst());
        }

        testerList.addFirst(20);
        assertEquals(20, (long) testerList.pollFirst());
    }

    @Test
    public void addLastAndPollLast() throws Exception {
        testerList.addLast(20);
        assertEquals(20, (long) testerList.pollLast());
    }

    @Test
    public void pollFirst() throws Exception {
        for (int i = 0; i < testerList.size(); i++) {
            assertEquals(savedList.get(i), testerList.pollFirst());
        }
    }

    @Test
    public void removeFirstAndPeekFirst() throws Exception {
        for(int i = 0; i < savedList.size()-1; i++){
            testerList.removeFirst();
            assertEquals(savedList.get(i+1), testerList.peekFirst());
        }
    }

    @Test
    public void removeLastAndPeekLast() throws Exception {
        for(int i = savedList.size()-1; i > 0; i--){
            testerList.removeLast();
            assertEquals(savedList.get(i-1), testerList.peekLast());
        }
    }

    @Test
    public void pushAndPop() throws Exception {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        Random r = new Random();

        for(int i = 0; i < 100; i++){
            int number = r.nextInt(999);
            testerList.push(number);
            tempList.add(number);
        }

        for(int i = tempList.size()-1; i >= 0; i--){
            assertEquals(tempList.get(i), testerList.pop());
        }
    }
}
