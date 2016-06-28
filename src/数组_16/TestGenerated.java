package 数组_16;

import java.util.Arrays;

/**
 * Created by biezhihua on 16-6-28.
 */
public class TestGenerated {


    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));

        a = Generated.array(a, new CountingGenerator.Integer());

        System.out.println(Arrays.toString(a));

        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);

        System.out.println(Arrays.toString(b));
    }
}
