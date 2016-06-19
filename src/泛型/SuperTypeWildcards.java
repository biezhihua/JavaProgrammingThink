package 泛型;

import java.util.List;

/**
 * Created by biezhihua on 16-6-18.
 */
public class SuperTypeWildcards {

    static void writeTo(List<? super ConvraintArrays.Apple> apples) {
        apples.add(new ConvraintArrays.Apple());
        apples.add(new ConvraintArrays.Jonathan());

//        apples.add(new ConvraintArrays.Fruit());
    }
}
