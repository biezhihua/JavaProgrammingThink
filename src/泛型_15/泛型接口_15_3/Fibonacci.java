package 泛型_15.泛型接口_15_3;

/**
 * Created by biezhihua on 16-6-23.
 */
public class Fibonacci implements 泛型_15.Generator<Integer> {

    int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

}
