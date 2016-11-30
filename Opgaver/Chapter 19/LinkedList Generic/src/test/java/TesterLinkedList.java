/**
 * Created by David Stovlbaek on 18/09/16.
 */

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesterLinkedList {

    static LinkedListGeneric<Integer> tester;
    static LinkedListGeneric<String> tester2;
    static LinkedListGeneric<Person> tester3;


    @BeforeClass
    public static void setUp() throws Exception {
        tester = new LinkedListGeneric<Integer>();
        tester2 = new LinkedListGeneric<String>();
        tester3 = new LinkedListGeneric<Person>();
    }

    @Test
    public void addMethod () {
        tester.add(10);
        assertEquals(1, tester.size());
        tester.add(2);
        assertEquals(2, tester.size());

        tester2.add("Don");
        assertEquals(1, tester2.size());
        tester2.add("Pablo");
        assertEquals(2, tester2.size());

        tester3.add(new Person("Pablo", 40));
        assertEquals(1, tester3.size());
        tester3.add(new Person("Tom", 80));
        assertEquals(2, tester3.size());
    }

    @Test
    public void getMethod () throws Exception{

        assertEquals(10, tester.get(0).value);
        assertEquals(2, tester.get(1).value);

        assertEquals("Don", tester2.get(0).value);
        assertEquals("Pablo", tester2.get(1).value);
    }

    @Test(expected=NullPointerException.class)
    public void testNullPointerException() throws Exception{
        tester.get(-3);
    }

    @Test(expected=NullPointerException.class)
    public void testNullPointerException2() throws Exception{
        tester2.get(tester2.size()+1);
    }

}
