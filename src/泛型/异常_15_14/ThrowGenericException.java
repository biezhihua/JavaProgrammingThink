package 泛型.异常_15_14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biezhihua on 16-6-20.
 */
public class ThrowGenericException {

    interface Processor<T, E extends Exception> {
        void process(List<T> resultCollector) throws E;
    }

    static class ProcessRunner<T, E extends Exception> extends ArrayList<Processor<T, E>> {
        List<T> processAll() throws E {
            List<T> resultCollector = new ArrayList<>();
            for (Processor<T, E> processor : this) {
                processor.process(resultCollector);
            }
            return resultCollector;
        }
    }

    static class Failure1 extends Exception {
    }

    static class Processor1 implements Processor<String, Failure1> {

        static int count = 3;


        @Override
        public void process(List<String> resultCollector) throws Failure1 {
            if (count-- > 1) {
                resultCollector.add("Hep!");
            } else {
                resultCollector.add("Ho!");
            }

            if (count < 0) {
                throw new Failure1();
            }
        }
    }

    static class Failure2 extends Exception {
    }

    static class Processor2 implements Processor<Integer, Failure2> {

        static int count = 2;


        @Override
        public void process(List<Integer> resultCollector) throws Failure2 {
            if (count-- == 0) {
                resultCollector.add(47);
            } else {
                resultCollector.add(11);
            }

            if (count < 0) {
                throw new Failure2();
            }
        }
    }

    public static void main(String[] args) {
        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());;
        } catch (Failure1 failure1) {
            failure1.printStackTrace();
        }

        ProcessRunner<Integer, Failure2> runner1 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner1.add(new Processor2());
        }

        try {
            System.out.println(runner1.processAll());
        } catch (Failure2 failure2) {
            failure2.printStackTrace();
        }

    }
}
