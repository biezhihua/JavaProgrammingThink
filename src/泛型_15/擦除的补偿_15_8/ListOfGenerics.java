package 泛型_15.擦除的补偿_15_8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biezhihua on 16-6-26.
 */
public class ListOfGenerics<T> {

    private List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
