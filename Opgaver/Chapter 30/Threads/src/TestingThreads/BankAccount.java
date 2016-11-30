package TestingThreads;

/**
 * Created by David Stovlbaek on 28/09/16.
 */
public class BankAccount {
    private int balance;

    public BankAccount(int startBalance) {
        this.balance = startBalance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount){
        balance += amount;
    }
}
