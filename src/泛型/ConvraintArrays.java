package 泛型;

/**
 * Created by biezhihua on 16-6-18.
 */
public class ConvraintArrays {

    public static class Fruit {
    }

    public static class Apple extends Fruit {
    }


    public static class Jonathan extends Apple {
    }

    public static class Orange extends Fruit {
    }


    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];

        fruits[0] = new Apple();

        fruits[1] = new Jonathan();

        fruits[2] = new Fruit();

        fruits[3] = new Orange();
    }
}
