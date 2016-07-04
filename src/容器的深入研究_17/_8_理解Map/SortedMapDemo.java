package 容器的深入研究_17._8_理解Map;

import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by biezhihua on 16-7-3.
 */
public class SortedMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        new LinkedHashMap<Integer, String>(16, 0.75f, true);
    }
}
