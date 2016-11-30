package SharedCounter;

/**
 * Created by David Stovlbaek on 28/09/16.
 */
public class RunCounter {

    public static void main(String[] args) {


        for(int k = 0; k < 20; k++) {
            Counter counter = new Counter();
                Thread[] ts = new Thread[10];
                for (int i = 0; i < ts.length; i++) {
                    ts[i] = new Thread(new CounterThread(counter));
                    ts[i].start();
                }

                System.out.println(counter.getCounter());
        }
    }

}
