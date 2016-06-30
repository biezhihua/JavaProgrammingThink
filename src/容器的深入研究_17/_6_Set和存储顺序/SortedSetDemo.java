package 容器的深入研究_17._6_Set和存储顺序;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by biezhihua on 16-6-29.
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();

        sortedSet.first();
        sortedSet.last();
        sortedSet.iterator();

    }
}
