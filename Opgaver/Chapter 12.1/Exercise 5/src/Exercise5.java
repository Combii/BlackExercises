/**
 * Created by David Stovlbaek on 12/09/16.
 */
public class Exercise5 {

    double side1, side2, side3;


    /** Construct a triangle with the specified sides */
    public Exercise5(double side1, double side2, double side3) throws IllegalTriangleException {

        if(side1+side2 < side3 || side1+side3 < side2 || side2+side3 < side1) throw new IllegalTriangleException();

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

}
