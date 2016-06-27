package 泛型_15.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-19.
 */
public class SelfBounding {

    public static void main(String[] args) {
        A a = new A();
        a.setElement(new A());

        a = a.getElement();

        C c = new C();

        c = c.setAndGet(new C());
    }

}

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    public T getElement() {
        return element;
    }

    public SelfBounded<T> setElement(T element) {
        this.element = element;
        return this;
    }
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        setElement(arg);
        return getElement();
    }
}

class D {
}

class F extends SelfBounded {
}