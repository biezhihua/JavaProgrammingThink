package 泛型.问题_15_11;

import 泛型.Genericator;

/**
 * Created by biezhihua on 16-6-19.
 */
public class PrimitiveGenericTest {

    static class FArray {
        public static <T> T[] fill(T[] a, Genericator<T> genericator) {
            for (int i = 0; i < a.length; i++) {
                a[i] = genericator.next();
            }
            return a;
        }
    }


    public static void main(String[] args) {
    }

}
