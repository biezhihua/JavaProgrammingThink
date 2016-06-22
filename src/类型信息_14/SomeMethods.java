package 类型信息_14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by biezhihua on 16-6-22.
 */
public class SomeMethods {

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(p.matcher(method.toGenericString()).replaceAll(""));
                }
                for (Constructor constructor : constructors) {
                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            }else {

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
