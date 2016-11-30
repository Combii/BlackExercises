/**
 * Created by David Stovlbaek on 13/09/16.
 */
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MyArrayListGenericTest{

    @Test
    public void addMethod() {
        MyArrayListGeneric<Integer> tester = new MyArrayListGeneric<Integer>(); // MyClass is tested

        // assert statements
        tester.add(10);
        assertEquals(1, tester.getSize());
        assertEquals(10, (long) tester.get(0));

        tester.add(2);
        assertEquals(2, tester.getSize());
        assertEquals(2, (long) tester.get(1));

    }

}

