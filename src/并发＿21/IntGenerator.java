package 并发＿21;

/**
 * Created by biezhihua on 16-7-8.
 */
public abstract  class IntGenerator {

    //
    private volatile  boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
