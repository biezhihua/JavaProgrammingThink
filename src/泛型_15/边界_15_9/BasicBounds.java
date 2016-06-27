package 泛型_15.边界_15_9;

import java.awt.*;

/**
 * Created by biezhihua on 16-6-26.
 */
public class BasicBounds {

    public static void main(String[] args) {
        Solid<Bounded> boundedSolid = new Solid<>(new Bounded());
        boundedSolid.color();
        boundedSolid.weight();
        boundedSolid.getX();
    }

}

interface HasColor {
    Color getColor();
}

class Colored<T extends HasColor> {
    T item;

    public Colored(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

// Multiple bounds
class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getY() {
        return item.y;
    }

    int getX() {
        return item.x;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    public Solid(T item) {
        this.item = item;
    }

    Color color() {
        return item.getColor();
    }

    T getItem() {
        return item;
    }

    int getY() {
        return item.y;
    }

    int getX() {
        return item.x;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}







