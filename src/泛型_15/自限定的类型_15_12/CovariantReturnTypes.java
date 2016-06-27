package 泛型_15.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-20.
 */
public class CovariantReturnTypes {

    void test(DerivedGetter derivedGetter) {
        Derived derived = derivedGetter.get();
    }

}

class Base {
}

class Derived extends Base {

}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    Derived get();
}