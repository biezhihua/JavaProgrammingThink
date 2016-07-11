package 并发＿21._共享受限资源;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by biezhihua on 16-7-8.
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    public int getI() {
        return i;
    }

    private  synchronized void evenIncrement() {
        i++;i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
        executorService.execute(atomicityTest);
        while (true) {
            int va = atomicityTest.getI();
            if (va % 2 != 0) {
                System.out.println(va);
                System.exit(0);
            }
        }
    }
}
