package 泛型;

/**
 * Created by biezhihua on 16-6-17.
 */
public class InheritBounds {

    static class HoldItem<T> {
        T item;

        public HoldItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }
    }

    static class Colored2<T extends BasicBounds.HasColor> extends HoldItem<T> {

        public Colored2(T item) {
            super(item);
        }

        BasicBounds.Color color() {
            return item.getColor();
        }
    }

    static class ColoredDimension2<T extends BasicBounds.Dimension & BasicBounds.HasColor> extends Colored2<T> {

        public ColoredDimension2(T item) {
            super(item);
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

    static class Solid2<T extends BasicBounds.Dimension & BasicBounds.HasColor & BasicBounds.Weight> extends ColoredDimension2<T> {

        public Solid2(T item) {
            super(item);
        }

        int weight() {
            return item.weight();
        }
    }

    public static void main(String[] args) {
        Solid2<BasicBounds.Bounded> solid2 = new Solid2<>(new BasicBounds.Bounded());
        solid2.weight();
        solid2.color();
        solid2.getY();
    }


}
