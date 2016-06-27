package 泛型_15.泛型接口_15_3;

/**
 * Created by biezhihua on 16-6-23.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}


class Mocha extends Coffee {

}

class Cappuccino extends Coffee {

}

class Americano extends Coffee {

}

class Breve extends Coffee {

}

class Latte extends Coffee {

}

