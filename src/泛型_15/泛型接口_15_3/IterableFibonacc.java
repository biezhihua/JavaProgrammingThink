package 泛型_15.泛型接口_15_3;

import java.util.Iterator;

/**
 * Created by biezhihua on 16-6-23.
 */
public class IterableFibonacc extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacc(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacc.this.next();
            }
        };
    }
}
