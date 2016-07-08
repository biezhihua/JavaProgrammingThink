package 并发＿21;

import java.util.concurrent.TimeUnit;

/**
 * Created by biezhihua on 16-7-6.
 */
public class Daemons {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println("thread.isDaemon = " + thread.isDaemon() + ",");
        TimeUnit.SECONDS.sleep(1);
    }

}

class Daemon implements Runnable {

    Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started.");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.printf("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
