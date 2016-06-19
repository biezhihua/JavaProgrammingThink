package 泛型.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-19.
 */
public class SelfBounding {

    static class SelfBounded<T extends SelfBounded<T>> {
        T element;

        public T getElement() {
            return element;
        }

        public SelfBounded<T> setElement(T element) {
            this.element = element;
            return this;
        }
    }

    static class A extends SelfBounded<A> {
    }

    static class B extends SelfBounded<A> {
    }

    static class C extends SelfBounded<C> {
        C setAndGet(C arg) {
            setElement(arg);
            return getElement();
        }
    }

    static class D {
    }

    static class F extends SelfBounded {
    }

    public static void main(String[] args) {
        A a = new A();
        a.setElement(new A());

        a = a.getElement();

        C c = new C();

        c = c.setAndGet(new C());
    }

}
