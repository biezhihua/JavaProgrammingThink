package 泛型_15.通配符_15_10;

import java.util.Arrays;
import java.util.List;

/**
 * Created by biezhihua on 16-6-26.
 */
public class GenericReading {

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<ConvraintArrays.Apple> apples = Arrays.asList(new ConvraintArrays.Apple());
    static List<ConvraintArrays.Fruit> fruits = Arrays.asList(new ConvraintArrays.Fruit());

    static void f1() {
        ConvraintArrays.Apple a = readExact(apples);
        ConvraintArrays.Fruit f = readExact(fruits);

        f = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<ConvraintArrays.Fruit> fruitReader = new Reader<>();

        ConvraintArrays.Fruit f = fruitReader.readExact(fruits);
//        ConvraintArrays.Fruit fa= fruitReader.readExact(apples);
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<ConvraintArrays.Fruit> fruitCovariantReader = new CovariantReader<>();
        ConvraintArrays.Fruit fruit1 = fruitCovariantReader.readCovariant(fruits);
        ConvraintArrays.Fruit fruit = fruitCovariantReader.readCovariant(apples);
    }

}
