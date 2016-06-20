package 泛型.对缺乏潜在类型机制的补偿_15_17;

import 泛型.Generator;

import java.util.Collection;

/**
 * Created by biezhihua on 16-6-20.
 */
public class Fill2 {

    interface Addable<T> {
        void add(T t);
    }

    // Classtoken version
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++) {
            try {
                addable.add(classToken.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // Generator version
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }

    // To adapt a base type, you must use composition.
    // Make any Collection Addable using composition.
    public static class AddableCollectionAdapter<T> implements Addable<T> {

        private Collection<T> c;

        public AddableCollectionAdapter(Collection<T> c) {
            this.c = c;
        }

        @Override
        public void add(T t) {
            c.add(t);
        }
    }

    public static class Adapter {
        public static <T> Addable<T> collectionAdapter(Collection<T> collection) {
            return new AddableCollectionAdapter<>(collection);
        }
    }

    public static class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {

        @Override
        public void add(T t) {
            super.add(t);
        }
    }


}
