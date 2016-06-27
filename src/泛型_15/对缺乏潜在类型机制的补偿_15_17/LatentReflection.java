package 泛型_15.对缺乏潜在类型机制的补偿_15_17;

import java.lang.reflect.Method;

/**
 * Created by biezhihua on 16-6-20.
 */
public class LatentReflection {

    static class Mime {
        public void walkAgainstTheWind() {

        }

        public void sit() {
            System.out.println("Mime.sit");
        }

        public void pushInvisibleWalls() {

        }

        @Override
        public String toString() {
            return "Mime";
        }
    }

    static class SmartDog {
        public void speak() {
            System.out.println("Woof!");
        }

        public void sit() {
            System.out.println("Sitting");
        }

        public void reproduce() {

        }
    }

    static class CommunicateReflectively {
        public static void perform(Object speaker) {
            Class<?> spkr = speaker.getClass();
            try {
                try {
                    Method speak = spkr.getMethod("speak");
                    speak.invoke(speaker);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                throw new RuntimeException(speaker.toString(), e);
            }
        }
    }


}
