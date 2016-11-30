import java.util.Arrays;

/**
 * Created by David Stovlbaek on 06/10/16.
 */
public class RunProgram {
    public static void main(String[] args) {
        HashIntSet mySet = new HashIntSet();
        HashIntSet mySet2 = new HashIntSet();

        mySet.add(-2);
        mySet.add(3);
        mySet.add(5);
        mySet.add(6);
        mySet.add(8);

        System.out.println(mySet);

        mySet2.add(2);
        mySet2.add(3);
        mySet2.add(6);
        mySet2.add(8);
        mySet2.add(11);

        //System.out.println(mySet2);

        System.out.println(Arrays.toString(mySet.toArray()));
        //System.out.println(mySet);

        //System.out.println(mySet.containsAll(mySet2));
    }
}
