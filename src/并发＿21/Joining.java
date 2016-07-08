package 并发＿21;

/**
 * Created by biezhihua on 16-7-8.
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy", 100);
        Sleeper grumpy = new Sleeper("Grumpy", 100);

        Joiner dopey = new Joiner("Dopey", sleeper);
        Joiner doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }
}

class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(getName() + " was interrupted. " + " is interrupted:" + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "join completed");
    }
}
