package 数组_16;

import 泛型_15.Generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by biezhihua on 16-6-28.
 */
public class CompType implements Comparable<CompType> {

    int i;
    int j;

    private static int count = 1;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }


    @Override
    public int compareTo(CompType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }

    private static Random random = new Random(47);

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(random.nextInt(100), random.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());

        Arrays.sort(a, Collections.reverseOrder());

    }

}
