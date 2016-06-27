package 泛型_15.一个堆栈类_15_2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by biezhihua on 16-6-23.
 */
public class RandomList<T> {

    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
}
