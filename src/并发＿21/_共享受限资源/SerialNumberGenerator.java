package 并发＿21._共享受限资源;

/**
 * Created by biezhihua on 16-7-8.
 */
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }

}
