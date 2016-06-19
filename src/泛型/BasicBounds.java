package 泛型;


/**
 * Created by biezhihua on 16-6-17.
 */
public class BasicBounds {
    public static class Dimension {
        public int x, y, z;
    }

    public static class Color {
        public int color;
    }

    public interface HasColor {
        Color getColor();
    }

    public  static class Colored<T extends HasColor> {
        T item;

        Colored(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        Color color() {
            return item.getColor();
        }
    }

    public static class ColoredDimension<T extends Dimension & HasColor> {
        T item;

        ColoredDimension(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        Color color() {
            return item.getColor();
        }

        int getX() {
            return item.x;
        }

        int getY() {
            return item.y;
        }

        int getZ() {
            return item.z;
        }
    }

    public interface Weight {
        int weight();
    }

    public static class Solid<T extends Dimension & HasColor & Weight> {
        T item;

        public Solid(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        Color color() {
            return item.getColor();
        }

        int getX() {
            return item.x;
        }

        int getY() {
            return item.y;
        }

        int getZ() {
            return item.z;
        }

        int weight() {
            return item.weight();
        }
    }

    static class Bounded extends Dimension implements HasColor, Weight {

        @Override
        public Color getColor() {
            return null;
        }

        @Override
        public int weight() {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
