package 泛型_15.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-27.
 */
public class NotSelfBounded<T> {
    T element;

    public T getElement() {
        return element;
    }

    public NotSelfBounded<T> setElement(T element) {
        this.element = element;
        return this;
    }
}

class A2 extends NotSelfBounded<A2> {
}

class B2 extends NotSelfBounded<A2> {

}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) {
        setElement(arg);
        return getElement();
    }
}

class D2{}

class E2 extends NotSelfBounded<D2> {

}


