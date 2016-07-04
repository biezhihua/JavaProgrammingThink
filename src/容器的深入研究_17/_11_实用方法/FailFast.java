package 容器的深入研究_17._11_实用方法;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by biezhihua on 16-7-4.
 */
public class FailFast {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();

        strings.add("a");

        iterator.next();
    }

}
