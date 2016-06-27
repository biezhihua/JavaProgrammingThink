package 泛型_15.通配符_15_10;

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
