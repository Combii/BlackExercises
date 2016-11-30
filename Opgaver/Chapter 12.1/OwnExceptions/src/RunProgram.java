import java.util.Scanner;

/**
 * Created by David Stovlbaek on 17/09/16.
 */
public class RunProgram {

    public static void main(String[] args) throws Exception{
    //calculateDivide();
        arrayOutOfBound(-2);
    }



    public static void calculateDivide() throws CannotDivideByZeroException{
        Scanner input = new Scanner(System.in);

        int nm1, nm2;

        System.out.println("Write your first number to divide by: ");
        nm1 = input.nextInt();
        System.out.println("Write your second number to divide by: ");
        nm2 = input.nextInt();

        if(nm1 == 0 || nm2 == 0) throw new CannotDivideByZeroException(nm1 + " / " + nm2);

        System.out.println(nm1 + " / " + nm2 + " = " + nm1 / nm2);
    }

    public static boolean arrayOutOfBound(int index) throws CustomArrayOutOfBoundException{

        int[] arr = new int[10];

        if(index < 10 || index < 0) throw new CustomArrayOutOfBoundException(index);

        return true;
    }
}
