/**
 * Created by David Stovlbaek on 14/09/16.
 */
public class IllegalTriangleException extends Exception {

    public IllegalTriangleException() {
    }

    @Override
    public String toString() {
        return "The sum of any two sides is greater than the other side of your Triangle.";
    }
}
