package 容器的深入研究_17._8_理解Map;

import java.util.Map;
import java.util.Set;

/**
 * Created by biezhihua on 16-7-1.
 */
public class Maps {

    public static void printKeys(Map<Integer, String> map) {
        System.out.println("Size = " + map.size() + ", ");
        System.out.println("Keys: " + map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        System.out.println(map.getClass().getSimpleName());
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {

        }
    }
}
