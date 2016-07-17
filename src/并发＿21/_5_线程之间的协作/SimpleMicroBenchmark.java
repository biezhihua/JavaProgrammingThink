package 并发＿21._5_线程之间的协作;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by biezhihua on 16-7-17.
 */
public class SimpleMicroBenchmark {

    static long test(Incrementable incrementable) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000000L; i++) {
            incrementable.increment();
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        long synchTime = test(new SychronizingTest());
        long lockTime = test(new LocalingTest());

        System.out.printf("synchronized: %1$10d\n", synchTime);
        System.out.printf("lock        : %1$10d\n", lockTime);
        System.out.printf("%1$.3f", (double)lockTime/(double)synchTime);
    }
}

abstract class Incrementable {
    protected long counter = 0;

    public abstract void increment();
}

class SychronizingTest extends Incrementable {

    @Override
    public synchronized void increment() {
        ++counter;
    }
}

class LocalingTest extends Incrementable {

    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}
