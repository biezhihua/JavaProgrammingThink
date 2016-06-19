package 泛型;

/**
 * Created by biezhihua on 16-6-18.
 */
public class Holder<T> {

    T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<ConvraintArrays.Apple> appleHolder = new Holder<>(new ConvraintArrays.Apple());
        ConvraintArrays.Apple d = appleHolder.getValue();
        appleHolder.setValue(d);

        Holder<? extends ConvraintArrays.Fruit> fruite = appleHolder;

        ConvraintArrays.Fruit value = fruite.getValue();

        d = (ConvraintArrays.Apple) fruite.getValue()

        ;
    }
}
