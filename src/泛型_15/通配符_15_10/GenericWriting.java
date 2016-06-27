package 泛型_15.通配符_15_10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biezhihua on 16-6-18.
 */
public class GenericWriting {

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<ConvraintArrays.Apple> apples = new ArrayList<ConvraintArrays.Apple>();

    static List<ConvraintArrays.Fruit> fruits = new ArrayList<ConvraintArrays.Fruit>();

    static void f1() {
        writeExact(apples, new ConvraintArrays.Apple());
        writeExact(fruits, new ConvraintArrays.Apple());
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new ConvraintArrays.Apple());
        writeWithWildcard(fruits, new ConvraintArrays.Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
