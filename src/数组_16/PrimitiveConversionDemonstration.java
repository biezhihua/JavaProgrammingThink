package 数组_16;

/**
 * Created by biezhihua on 16-6-28.
 */
public class PrimitiveConversionDemonstration {

    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        int[] primitive = ConverTo.primitive(a);
    }

}
