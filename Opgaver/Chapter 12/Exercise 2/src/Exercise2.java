/**
 * Created by David Stovlbaek on 07/09/16.
 */

public class Exercise2 {

    public static void main(String[] args) {

        writeNums(5);

    }

    public static void writeNums(int n) {
        try{
            if (n < 1) {
                throw new IllegalArgumentException();
            } else {
                writeNums(n - 1);
                System.out.print(n + " ");
            }
        }
        catch (Exception ignored){
        }
    }

    }
