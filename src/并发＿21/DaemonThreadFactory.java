package 并发＿21;

import java.util.concurrent.ThreadFactory;

/**
 * Created by biezhihua on 16-7-6.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
