import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by David Stovlbaek on 12/09/16.
 */
public class Exercise2 {


    public static void main(String[] args) throws Exception{
        randomCalculation();
    }

    public static void randomCalculation() throws Exception{
        Random randomGenerator = new Random();

        int randomInt, randomInt2, check, result;

        randomInt = randomGenerator.nextInt(11);
        randomInt2 = randomGenerator.nextInt(11);

        check = randomGenerator.nextInt(3);

        while(true){
            Scanner input = new Scanner(System.in);

        if(check == 0){
            result = randomInt+randomInt2;
            System.out.print(randomInt + " + " + randomInt2 + " = ");
        }
        else if(check == 1){
            result = randomInt-randomInt2;
            System.out.print(randomInt + " - " + randomInt2 + " = ");
        }
        else{
            result = randomInt*randomInt2;
            System.out.print(randomInt + " * " + randomInt2 + " = ");
        }

            try{
                if(input.nextInt() != result){
                    throw new InputMismatchException();
                }
                System.out.println("Correct!");
                break;
            }
            catch (Exception e){
                System.out.println("Wrong input. Try again.");
            }
        }
    }

}
