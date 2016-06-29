package 容器的深入研究_17.填充容器_17_2;

/**
 * Created by biezhihua on 16-6-27.
 */
public class Pair<K, V> {

    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.value = value;
        this.key = key;
    }
}
