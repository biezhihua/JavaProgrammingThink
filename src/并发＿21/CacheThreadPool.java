package 并发＿21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by biezhihua on 16-7-6.
 */
public class CacheThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executor.execute(new LiftOff());
        }
        executor.shutdown();
    }

}
