package 泛型_15.擦除的补偿_15_8;

import java.lang.reflect.Array;

/**
 * Created by biezhihua on 16-6-26.
 */
public class GenericArrayWithTypeToken<T> {


    private final T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int sz){
        array = (T[]) Array.newInstance(type, sz);
    }

}
