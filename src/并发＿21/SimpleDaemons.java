package 并发＿21;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * Created by biezhihua on 16-7-6.
 */
public class SimpleDaemons implements Runnable {


    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " " + this);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All daemon started");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
