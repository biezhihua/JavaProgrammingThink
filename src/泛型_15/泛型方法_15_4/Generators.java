package 泛型_15.泛型方法_15_4;

import 泛型_15.Generator;

import java.util.Collection;

/**
 * Created by biezhihua on 16-6-26.
 */
public class Generators {

    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
    }
}
