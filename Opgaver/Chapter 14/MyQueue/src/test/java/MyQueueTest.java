import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David Stovlbaek on 24/09/16.
 */
public class MyQueueTest {

    static MyQueue<Integer> testQueue;

    @Before
    public void setUp(){
        testQueue = new LinkedListGeneric<Integer>();

        testQueue.add(2);
        testQueue.add(4);
        testQueue.add(9);
        testQueue.add(30);
    }

    @Test
    public void AddingNewElementsToList() throws Exception {

        testQueue.add(20);
        assertEquals(5, testQueue.size());
        testQueue.add(50);
        assertEquals(6, testQueue.size());
        testQueue.add(2);
        assertEquals(7, testQueue.size());
        testQueue.add(30);
        assertEquals(8, testQueue.size());
    }

    @Test
    public void GettingElementAndDeletingFromList() throws Exception {

        assertEquals(2, (int) testQueue.poll());
        assertEquals(3, testQueue.size());

        assertEquals(4, (int) testQueue.poll());
        assertEquals(2, testQueue.size());

        assertEquals(9, (int) testQueue.poll());
        assertEquals(1, testQueue.size());

        assertEquals(30, (int) testQueue.poll());
        assertEquals(0, testQueue.size());
    }

    @Test(expected = NullPointerException.class)
    public void PollNullPointerExceptionFromPoll(){
        while(testQueue.size() != -1) {
            testQueue.poll();
        }
    }

    @Test
    public void PeekReturningFirstAddedElement() throws Exception {
        assertEquals(2, (long) testQueue.peek());
        testQueue.remove();
        assertEquals(4, (long) testQueue.peek());
    }

    @Test(expected = NullPointerException.class)
    public void PeekNullPointerExceptionFromPoll(){
        for(int i = testQueue.size()-1; i >= 0; i--){
            testQueue.remove();
        }
        testQueue.peek();
    }
}