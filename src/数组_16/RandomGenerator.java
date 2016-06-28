package 数组_16;

import 泛型_15.Generator;

import java.util.Random;

/**
 * Created by biezhihua on 16-6-28.
 */
public class RandomGenerator {

    private static Random random = new Random(47);


    public static class Boolean implements Generator<java.lang.Boolean> {
        @Override
        public java.lang.Boolean next() {
            return random.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {

        @Override
        public java.lang.Byte next() {
            return (byte) random.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {

        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[random.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String extends CountingGenerator.String {

        {
            cg = new CountingGenerator.Character();
        }

    }

    public static class Short implements Generator<java.lang.Short> {

        @Override
        public java.lang.Short next() {
            return (short) random.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {

        private int mod = 1000;

        public Integer(int mod) {
            this.mod = mod;
        }

        public Integer() {
        }

        @Override
        public java.lang.Integer next() {
            return random.nextInt(mod);
        }
    }

    public static class Long implements Generator<java.lang.Long> {

        private int mod = 1000;

        public Long(int mod) {
            this.mod = mod;
        }

        public Long() {
        }

        @Override
        public java.lang.Long next() {
            return new java.lang.Long(random.nextInt(mod));
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        @Override
        public java.lang.Float next() {

            int round = Math.round(random.nextFloat() * 100);
            return ((float) round) / 100;
        }
    }

    public static class Double implements Generator<java.lang.Double> {

        @Override
        public java.lang.Double next() {
            long round = Math.round(random.nextDouble() * 100);
            return ((double) round) / 100;
        }
    }
}
