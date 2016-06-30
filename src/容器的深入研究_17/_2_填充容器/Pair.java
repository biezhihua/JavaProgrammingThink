package 容器的深入研究_17._2_填充容器;

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
