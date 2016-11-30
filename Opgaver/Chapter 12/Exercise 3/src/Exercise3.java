/**
 * Created by David Stovlbaek on 07/09/16.
 */

public class Exercise3 {

    public static void main(String[] args) {

        writeSequence2(10);

    }

    public static void writeSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        } else if (n % 4 == 0) {
            System.out.print("2 * ");
            writeSequence(n / 4);
            System.out.print(" * 2");
        } else if (n % 2 == 0) {
            System.out.print("2 * " + n / 2);
        } else {
            System.out.print(n);
        }
    }

    public static void writeSequence2(int n) {
        try {
            if (n < 1) {
                throw new IllegalArgumentException();
            } else {
                if (n % 2 != 0) {
                    System.out.print(Math.round(n / 2 + 0.5) + " ");
                    writeSequence2(n - 2);
                    if(n != 1) {
                        System.out.print(Math.round(n / 2 + 0.5) + " ");
                    }
                }
                else {
                    System.out.print(Math.round(n / 2) + " ");
                    writeSequence2(n - 2);
                    System.out.print(Math.round(n / 2) + " ");
                }
            }
        } catch (Exception ignored) {

        }
    }
}
