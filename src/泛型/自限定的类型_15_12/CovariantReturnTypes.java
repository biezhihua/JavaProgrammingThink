package 泛型.自限定的类型_15_12;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by biezhihua on 16-6-20.
 */
public class CovariantReturnTypes {

    static class Base {
    }

    static class Derived extends Base {

    }

    interface OrdinaryGetter {
        Base get();
    }

    interface DerivedGetter extends OrdinaryGetter {
        Derived get();
    }
}
