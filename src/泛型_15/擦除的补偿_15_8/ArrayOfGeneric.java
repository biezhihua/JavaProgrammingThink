package 泛型_15.擦除的补偿_15_8;

/**
 * Created by biezhihua on 16-6-26.
 */
public class ArrayOfGeneric {

    static final int size = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
//        gia = (Generic<Integer>) new Object[size];
        gia= (Generic<Integer> [])new Generic[size];
    }
}
