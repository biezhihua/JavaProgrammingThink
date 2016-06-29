package 容器的深入研究_17.填充容器_17_2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by biezhihua on 16-6-27.
 */

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}


public class FillingLists {

    public static void main(String[] args) {
        ArrayList<StringAddress> stringAddresses = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello!")));
        System.out.println(stringAddresses);
        Collections.fill(stringAddresses, new StringAddress("World"));
        System.out.println(stringAddresses);
    }

}
