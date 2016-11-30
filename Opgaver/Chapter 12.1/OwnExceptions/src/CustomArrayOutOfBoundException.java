/**
 * Created by David Stovlbaek on 17/09/16.
 */
public class CustomArrayOutOfBoundException extends Exception{

    private int index;

    public CustomArrayOutOfBoundException(int index){
        this.index = index;
    }

    @Override
    public String toString() {
        return "Array out of bound: " + index;
    }
}
