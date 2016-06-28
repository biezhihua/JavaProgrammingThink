package 数组_16;

import 泛型_15.Generator;

/**
 * Created by biezhihua on 16-6-28.
 */
public class GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.printf(type.getSimpleName() + ": ");
            try {
                Generator<?> generator = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.printf(generator.next() + " ");
                }
                System.out.println();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        test(CountingGenerator.class);
        test(RandomGenerator.class);
    }
}
