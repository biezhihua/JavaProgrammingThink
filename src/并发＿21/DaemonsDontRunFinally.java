package 并发＿21;

import java.util.concurrent.TimeUnit;

/**
 * Created by biezhihua on 16-7-6.
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
    }
}

class ADaemon implements Runnable {

    @Override
    public void run() {
        System.out.println("Staring ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This should always run?");
        }
    }
}

