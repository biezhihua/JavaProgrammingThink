package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biezhihua on 16-6-18.
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        List<? extends ConvraintArrays.Fruit> fruits = new ArrayList<>();

//        fruits.add(new ConvraintArrays.Apple());
//        fruits.add(new ConvraintArrays.Fruit());
//        fruits.add(new Object());

        fruits.add(null);

//        fruits.add(new ConvraintArrays.Orange());

    }


}
