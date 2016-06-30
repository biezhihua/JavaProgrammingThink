package 容器的深入研究_17._2_填充容器;

import 数组_16.CountingGenerator;
import 数组_16.RandomGenerator;
import 泛型_15.Generator;

import java.util.Iterator;

/**
 * Created by biezhihua on 16-6-29.
 */
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));

        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(), 8));
    }
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {


    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
        };
    }
}
