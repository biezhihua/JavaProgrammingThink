package 并发＿21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by biezhihua on 16-7-8.
 */
public class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
