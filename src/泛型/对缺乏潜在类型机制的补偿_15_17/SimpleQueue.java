package 泛型.对缺乏潜在类型机制的补偿_15_17;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by biezhihua on 16-6-20.
 */
public class SimpleQueue<T> implements Iterable<T> {

    LinkedList<T> storage = new LinkedList<T>();

    public void add(T t) {
        storage.offer(t);
    }

    public T get() {
        return storage.poll();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
