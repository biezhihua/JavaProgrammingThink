package 并发＿21._共享受限资源;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by biezhihua on 16-7-8.
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even ! " + id);
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int counts) {
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < counts; i++) {
            executorService.execute(new EvenChecker(gp, i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
