package 泛型_15.异常_15_14;

import java.util.Date;

/**
 * Created by biezhihua on 16-6-20.
 */
public class Decoration {

    static class Basic {
        private String value;

        public void set(String val) {
            value = val;
        }

        public String get() {
            return value;
        }
    }

    static class Decorator extends Basic {
        protected Basic basic;

        public Decorator(Basic basic) {
            this.basic = basic;
        }

        @Override
        public void set(String val) {
            basic.set(val);
        }

        @Override
        public String get() {
            return basic.get();
        }
    }

    static class TimeStamped extends Decorator {
        public TimeStamped(Basic basic) {
            super(basic);
            timeStamp = new Date().getTime();
        }

        final long timeStamp;

        public long getTimeStamp() {
            return timeStamp;
        }
    }

    static class SerialNumbered extends Decorator {

        private static long counter = 1;
        private final long serialNumber = counter++;

        public SerialNumbered(Basic basic) {
            super(basic);
        }

        public long getSerialNumber() {
            return serialNumber;
        }
    }

    public static void main(String[] args) {
        new TimeStamped(new Basic());
        new TimeStamped(new SerialNumbered(new Basic()));
    }


}
