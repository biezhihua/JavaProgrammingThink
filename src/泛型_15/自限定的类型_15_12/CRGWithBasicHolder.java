package 泛型_15.自限定的类型_15_12;

/**
 * Created by biezhihua on 16-6-19.
 */
public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype();
        Subtype st2 = new Subtype();
        st1.setElement(st2);
        Subtype st3 = st1.getElement();
        st1.f();
    }
}

class Subtype extends BasicHolder<Subtype> {
}