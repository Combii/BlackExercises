package HelloThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by David Stovlbaek on 28/09/16.
 */
public class ReverseHello{

    public static void main(String[] args) {
        /*Thread[] ts = new Thread[50];
        for (int i = 0; i < 50; i++) {
            ts[i] = new Thread(new HelloThread());
        }*/

        new Thread(new HelloThread()).start();

        /*
        for(int i = ts.length-1; i  >= 0; i--){
            ts[i].start();
        }

        /*
       ExecutorService es = Executors.newFixedThreadPool(1);

        for(int i = ts.length-1; i  >= 0; i--){
            es.submit(ts[i]);
        }

        try{
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (Exception e){
        }
        */
    }

}
