package 容器的深入研究_17._11_实用方法;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by biezhihua on 16-7-4.
 */
public class Utilities {

    static List<String> list = Arrays.asList("one two three four five six".split(" "));

    public static void main(String[] args) {
        System.out.println(list);

        System.out.println(Collections.disjoint(list, Collections.singletonList("Four")));

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        System.out.println(Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        System.out.println(Collections.min(list, String.CASE_INSENSITIVE_ORDER));

        List<String> subList = Arrays.asList("four five six".split(" "));
        System.out.println(Collections.indexOfSubList(list, subList));
        System.out.println(Collections.lastIndexOfSubList(list, subList));
        Collections.reverse(list);
        System.out.println();
    }

}
