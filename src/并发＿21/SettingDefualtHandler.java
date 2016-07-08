package 并发＿21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by biezhihua on 16-7-8.
 */
public class SettingDefualtHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }
}
