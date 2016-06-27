package 泛型_15.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-19.
 */
public class BasicHolder<T> {

    T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
