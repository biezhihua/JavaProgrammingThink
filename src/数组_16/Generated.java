package 数组_16;

import 容器的深入研究_17.填充容器_17_2.CollectionData;
import 泛型_15.Generator;

/**
 * Created by biezhihua on 16-6-28.
 */
public class Generated {

    public static <T> T[] array(T[] a, Generator<T> generator) {
        return new CollectionData<T>(generator, a.length).toArray(a);
    }

    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
}
