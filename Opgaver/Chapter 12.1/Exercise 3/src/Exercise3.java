import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by David Stovlbaek on 12/09/16.
 */
public class Exercise3 {


    public static void main(String[] args) throws Exception{

            Random randomGenerator = new Random();

            int[] list = new int[100];


            for(int i = 0; i < 100; i++){
                list[i] = randomGenerator.nextInt(101);
            }

            while(true) {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Write index you wish to receive a value from: ");
                    System.out.println(list[input.nextInt()]);
                    break;
                } catch (Exception e) {
                    System.out.println("Out of Bounds");
                }
            }
            //System.out.println(list[100]);
        }

    }
