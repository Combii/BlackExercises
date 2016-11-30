package SharedCounter;

/**
 * Created by David Stovlbaek on 28/09/16.
 */
public class CounterThread implements Runnable{

    private Counter counterObject;


    public CounterThread(Counter counterObject) {
        this.counterObject = counterObject;
    }

    @Override
    public void run() {
            counterObject.setCounter(counterObject.getCounter() + 10);
    }
}
