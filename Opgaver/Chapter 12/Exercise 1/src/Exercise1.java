/**
 * Created by David Stovlbaek on 07/09/16.
 */

public class Exercise1 {

    boolean check = true;
    int counter = 0;

    public static void main(String[] args) {

        //System.out.println(Math.round(Math.exp(-0.69*n)));
        //System.out.println((int) Math.pow(2,1));

        new Exercise1().starString(4);
        System.out.println();
        new Exercise1().starString(3);
    }

    public void starString(int n){
        if(check){
            n = (int) Math.pow(2, n);
            check = false;
        }
        if(n < 0){
            throw new IllegalArgumentException();
        }
        else if(n != 0){
            counter++;
            System.out.print("* ");
            starString(n - 1);
        }
    }




}
