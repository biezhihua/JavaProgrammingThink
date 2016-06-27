package 泛型_15.匿名内部类_15_5;

import 泛型_15.Generator;

/**
 * Created by biezhihua on 16-6-26.
 */
public class BankTeller {


}

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    private Customer() {

    }

    @Override
    public String toString() {
        return "Customer " + id;
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
