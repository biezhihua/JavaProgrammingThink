package 泛型_15.泛型方法_15_4;

import java.util.*;

/**
 * Created by biezhihua on 16-6-23.
 */
public class New {

    public static <K,V> Map<K,V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

}
