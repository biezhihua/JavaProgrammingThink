package 并发＿21;

/**
 * Created by biezhihua on 16-7-8.
 */
public class SimpleThread extends Thread {

    private int countDown = 5;

    private static int threadCount = 0;

    SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + "),";
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
