package TestingThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by David Stovlbaek on 28/09/16.
 */
public class RunThreads {
    public static void main(String[] args) {
            ExecutorService es = Executors.newFixedThreadPool(5);
            BankAccount account = new BankAccount(100);

            for (int i = 0; i < 5; i++) {
                Worker worker = new Worker(account);
                es.submit(worker);
            }

            es.shutdown();
        System.out.println(account.getBalance());
    }
}
