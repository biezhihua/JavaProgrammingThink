package 容器的深入研究_17._8_理解Map;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by biezhihua on 16-7-3.
 */
public class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog # " + number;
    }
}

class Prediction {

    private static Random random = new Random(47);

    private boolean shadow = random.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of winter!";
        } else {
            return "Early Spring";
        }
    }
}

class SpringDetecotr {

    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }

        System.out.println(map);

        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looing up predication for " + gh);
        if (map.containsKey(gh)) {
            System.out.println(map.get(gh));
        } else {
            System.out.println("Key not found :" + gh);
        }
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);

    }

}


