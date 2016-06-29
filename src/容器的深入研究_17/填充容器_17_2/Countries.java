package 容器的深入研究_17.填充容器_17_2;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by biezhihua on 16-6-29.
 */
public class Countries {

    static class FlyweightMap extends AbstractMap<String, String> {
        @Override
        public Set<Entry<String, String>> entrySet() {
            return null;
        }
    }


}


