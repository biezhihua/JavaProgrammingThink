package 容器的深入研究_17.填充容器_17_2;

import 泛型_15.Generator;

import java.util.LinkedHashSet;

/**
 * Created by biezhihua on 16-6-27.
 */
public class CollectionDataTest {

    public static void main(String[] args) {
        LinkedHashSet<String> strings = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        strings.addAll(CollectionData.list(new Government(), 15));
        System.out.println(strings);
    }

}

class Government implements Generator<String> {

    String[] foundation = ("strange women lying in ponds distributing swords is no basis for a system of government").split(" ");

    int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
