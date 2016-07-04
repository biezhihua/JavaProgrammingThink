package 容器的深入研究_17._8_理解Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biezhihua on 16-7-4.
 */
public class CountedString {

    private static List<String> created = new ArrayList<>();

    private String s;
    private int id = 0;
    private boolean a;
    private byte  b;
    private long l;
    private double d;


    public CountedString(String s) {
        this.s = s;
        created.add(s);
        for (String s2 : created) {
            id++;
        }
    }

    @Override
    public String toString() {
        return "String: " + s + " id:" + id + " hashCode : " + hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountedString that = (CountedString) o;

        if (id != that.id) return false;
        if (a != that.a) return false;
        if (b != that.b) return false;
        if (l != that.l) return false;
        if (Double.compare(that.d, d) != 0) return false;
        return s != null ? s.equals(that.s) : that.s == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = s != null ? s.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (a ? 1 : 0);
        result = 31 * result + (int) b;
        result = 31 * result + (int) (l ^ (l >>> 32));
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
