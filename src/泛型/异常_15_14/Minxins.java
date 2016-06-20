package 泛型.异常_15_14;

import java.util.Date;

/**
 * Created by biezhihua on 16-6-20.
 */
public class Minxins {

    interface TimeStamped {
        long getStamp();
    }

    static class TimeStampedImp implements TimeStamped {

        private long timeStamp;

        public TimeStampedImp() {
            this.timeStamp = new Date().getTime();
        }

        @Override
        public long getStamp() {
            return timeStamp;
        }
    }

    interface SerialNumbered {
        long getSerialNumber();
    }

    static class SerialNumberedImp implements SerialNumbered {

        private static long counter = 1;

        private final long serialNumber = counter++;

        @Override
        public long getSerialNumber() {
            return serialNumber;
        }
    }

    interface Basic {

        void set(String val);

        String get();
    }

    static class BasicImp implements Basic {

        private String value;

        @Override
        public void set(String val) {
            value = val;
        }

        @Override
        public String get() {
            return value;
        }
    }

    static class Mixin extends BasicImp implements TimeStamped, SerialNumbered {

        private TimeStamped timeStamped = new TimeStampedImp();

        private SerialNumbered serialNumbered = new SerialNumberedImp();

        @Override
        public long getSerialNumber() {
            return serialNumbered.getSerialNumber();
        }

        @Override
        public long getStamp() {
            return timeStamped.getStamp();
        }
    }

    public static void main(String[] args) {

        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();

        mixin1.set("test string 1");
        mixin1.set("test string 2");


    }
}
