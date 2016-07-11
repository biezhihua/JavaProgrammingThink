package 并发＿21._共享受限资源;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by biezhihua on 16-7-8.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():" + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            System.out.println(captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.untimed();
        attemptLocking.timed();

        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println("acquired");
            }
        }.start();

        Thread.yield();
        Thread.yield();
        Thread.yield();
        Thread.yield();

        attemptLocking.untimed();
        attemptLocking.timed();
    }
}
