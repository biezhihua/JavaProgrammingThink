package 并发＿21._共享受限资源;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by biezhihua on 16-7-16.
 */
public class FixedDiningPhilosophers {

    public static void main(String[] args) throws IOException {
        int ponder = 5;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            if (i < (size - 1)) {
                exec.execute(new Philosopher(chopsticks[i], chopsticks[(i + 1) % size], i, ponder));
            } else {
                exec.execute(new Philosopher(chopsticks[0], chopsticks[i], i, ponder));
            }
        }

        System.out.println("Press enter to quit");
        System.in.read();
        exec.shutdownNow();
    }
}
