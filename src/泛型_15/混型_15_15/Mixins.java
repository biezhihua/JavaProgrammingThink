package 泛型_15.混型_15_15;

/**
 * Created by biezhihua on 16-6-27.
 */
public class Mixins {
}

interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {

    @Override
    public long getStamp() {
        return 0;
    }
}
