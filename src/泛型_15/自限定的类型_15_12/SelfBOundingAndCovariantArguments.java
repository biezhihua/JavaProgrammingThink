package 泛型_15.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-27.
 */
public class SelfBOundingAndCovariantArguments {

    void test(Setter s1, Setter s2, SelfBoundSetter selfBoundSetter) {
        s1.set(s2);

    }

}

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {

}

