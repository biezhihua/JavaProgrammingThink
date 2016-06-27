package 容器的深入研究.填充容器_17_2;

import 泛型_15.Generator;

import java.util.ArrayList;

/**
 * Created by biezhihua on 16-6-27.
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }

}
