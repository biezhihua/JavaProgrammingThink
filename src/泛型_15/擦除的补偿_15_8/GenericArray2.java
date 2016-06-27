package 泛型_15.擦除的补偿_15_8;

/**
 * Created by biezhihua on 16-6-26.
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sze) {
        this.array = new Object[sze];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T getI(int index) {
        return (T) array[index];
    }

    public T[] rep() {
        return (T[]) array;
    }
}
