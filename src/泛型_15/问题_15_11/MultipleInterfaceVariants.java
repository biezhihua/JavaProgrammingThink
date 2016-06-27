package 泛型_15.问题_15_11;

/**
 * Created by biezhihua on 16-6-19.
 */
public class MultipleInterfaceVariants {

    interface Payable<T> {

    }

    class Employee implements Payable<Employee> {
    }

//    class Hourly extends Employee implements Payable<Hourly> {
//    }

}
