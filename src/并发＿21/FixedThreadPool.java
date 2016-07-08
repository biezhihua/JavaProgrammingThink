package 并发＿21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by biezhihua on 16-7-6.
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
