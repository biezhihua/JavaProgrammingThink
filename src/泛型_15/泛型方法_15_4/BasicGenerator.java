package 泛型_15.泛型方法_15_4;

import 泛型_15.Generator;

/**
 * Created by biezhihua on 16-6-26.
 */
public class BasicGenerator<T> implements Generator<T> {

    private  Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
