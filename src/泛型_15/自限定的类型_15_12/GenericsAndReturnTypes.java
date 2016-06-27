package 泛型_15.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-27.
 */
public class GenericsAndReturnTypes {

    void test(Getter getter) {
        Getter getter1 = getter.get();
        GenericGetter gg = getter.get();
    }

}


interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {

}
