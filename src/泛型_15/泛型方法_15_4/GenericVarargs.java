package 泛型_15.泛型方法_15_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biezhihua on 16-6-26.
 */
public class GenericVarargs {

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }
}
