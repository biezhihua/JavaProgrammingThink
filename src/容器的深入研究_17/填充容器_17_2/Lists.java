package 容器的深入研究_17.填充容器_17_2;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by biezhihua on 16-6-29.
 */
public class Lists {

    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");
        b = a.contains("1");
        ListIterator<String> stringListIterator = a.listIterator();
        stringListIterator.hasNext();
        stringListIterator.next();
    }

}
