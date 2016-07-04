package 容器的深入研究_17._8_理解Map;

import java.util.*;

/**
 * Created by biezhihua on 16-7-3.
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> kvMapEntry = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(kvMapEntry);
                found = true;
                break;
            }

        }
        if (!found) {
            buckets[index].add(kvMapEntry);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }

        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bukect : buckets) {
            if (bukect == null) {
                continue;
            }
            for (MapEntry<K, V> pair : bukect) {
                entries.add(pair);
            }
        }
        return entries;
    }
}


class MapEntry<K, V> implements Map.Entry<K, V> {

    K k;
    V v;

    public MapEntry(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }

    @Override
    public V setValue(V value) {
        V result = v;
        v = value;
        return result;
    }

    @Override
    public int hashCode() {
        return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MapEntry)) {
            return false;
        }

        MapEntry me = (MapEntry) obj;

        return (k == null ? me.k == null : k.equals(me.k)) && (v == null ? me.v == null : v.equals(me.v));

    }

    @Override
    public String toString() {
        return "MapEntry{" +
                "k=" + k +
                ", v=" + v +
                '}';
    }
}
