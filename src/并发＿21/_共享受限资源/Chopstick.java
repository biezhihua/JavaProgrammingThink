package 并发＿21._共享受限资源;

/**
 * Created by biezhihua on 16-7-16.
 */
public class Chopstick {

    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
