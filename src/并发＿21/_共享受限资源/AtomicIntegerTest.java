package 并发＿21._共享受限资源;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by biezhihua on 16-7-11.
 */
public class AtomicIntegerTest implements Runnable{

    private AtomicInteger i = new AtomicInteger();

    public int getI() {
        return i.get();
    }

    private void evenIncrement() {
        i.addAndGet(2);
    }


    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        },5000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        executorService.execute(atomicIntegerTest);

        while (true) {
            int val = atomicIntegerTest.getI();
            if (val % 2 != 0) {
                System.out.println(val);
            }
        }

    }
}
