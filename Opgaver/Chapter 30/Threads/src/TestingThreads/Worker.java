package TestingThreads;

/**
 * Created by David Stovlbaek on 28/09/16.
 */
public class Worker implements Runnable {
    private BankAccount account;
    private static int counter = 0;
    private int number;

    public Worker(BankAccount account){
        this.account = account;
        counter++;
        number = counter;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            int startBalance = account.getBalance();
            account.deposit(10);
            int endBalance = account.getBalance();
            //System.out.println("End Balance: " + endBalance + " Start Balance: " + startBalance + " Worker: " + number);
        }
    }
}
