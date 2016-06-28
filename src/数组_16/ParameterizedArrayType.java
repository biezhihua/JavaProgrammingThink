package 数组_16;

/**
 * Created by biezhihua on 16-6-28.
 */
public class ParameterizedArrayType {



}


class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}