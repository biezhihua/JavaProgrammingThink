package 泛型;

import java.util.Arrays;
import java.util.List;

/**
 * Created by biezhihua on 16-6-18.
 */
public class CompilerIntelligence {

    public static void main(String[] args) {
        List<? extends ConvraintArrays.Fruit> flist = Arrays.asList(new ConvraintArrays.Apple());

//        flist.add(new ConvraintArrays.Apple());

        ConvraintArrays.Apple apple = (ConvraintArrays.Apple) flist.get(0);

        flist.contains(new ConvraintArrays.Apple());

        flist.indexOf(new ConvraintArrays.Apple());
    }
}
