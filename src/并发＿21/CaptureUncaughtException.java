package 并发＿21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by biezhihua on 16-7-8.
 */
public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executorService.execute(new ExceptionThread());
    }

}

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Run by " + thread);
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread()");
        Thread thread = new Thread(r);
        System.out.println("create");
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        return thread;
    }
}


