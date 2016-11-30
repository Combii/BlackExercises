/**
 * Created by David Stovlbaek on 17/09/16.
 */
public class CannotDivideByZeroException extends Exception{

    private String calculation = "";

    public CannotDivideByZeroException(String calculation){
        this.calculation = calculation;
    }

    @Override
    public String toString() {
        return "You cannot divide by zero: " + calculation;
    }
}
