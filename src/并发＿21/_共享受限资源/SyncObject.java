package 并发＿21._共享受限资源;

/**
 * Created by biezhihua on 16-7-11.
 */
public class SyncObject {

    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("SyncObject.f");
            Thread.yield();
        }
    }

    public void g() throws InterruptedException {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("SyncObject.g");
                Thread.yield();
                Thread.sleep(10);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncObject syncObject = new SyncObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncObject.f();
            }
        }).start();

        syncObject.g();
    }
}
