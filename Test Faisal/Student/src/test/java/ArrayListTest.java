import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by David Stovlbaek on 15/09/16.
 */
public class ArrayListTest {

     static ArrayList<Integer> tester;

    @BeforeClass
    public static void setUp() throws Exception {
        tester = new ArrayList<Integer>(); // ArrayList Class is created
    }

        @Test
        public void addMethod () {

            tester.add(10);
            assertEquals(1, tester.size());

            tester.add(2);
            assertEquals(2, tester.size());

            System.out.println(tester);
        }

        @Test
        public void getMethod () {
            // assert statements
            System.out.println(tester);

            assertEquals(10, (long) tester.get(0));

            assertEquals(2, (long) tester.get(1));
        }

}