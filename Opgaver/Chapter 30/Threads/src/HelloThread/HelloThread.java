package HelloThread;
/**
 * Created by David Stovlbaek on 28/09/16.
 */
public class HelloThread implements Runnable{

    static int counter = 0;
    private int number;

    public HelloThread() {
        counter++;
        number = counter;
    }

    @Override
    public void run() {
            try {
                if(counter == 51) throw new Exception();
                Thread t1 = new Thread(new HelloThread());
                t1.start();
                synchronized (t1) {
                    t1.wait();
                }
                System.out.println(this);
            } catch (Exception e) {
                return;
            }
    }

    @Override
    public String toString() {
        return "Hello from Thread " + number + "!";
    }
}
