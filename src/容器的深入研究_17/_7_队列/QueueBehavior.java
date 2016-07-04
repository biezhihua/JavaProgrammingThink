package 容器的深入研究_17._7_队列;

import 泛型_15.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by biezhihua on 16-6-30.
 */
public class QueueBehavior {

    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < count; i++) {
            queue.offer(gen.next());
        }

        while (queue.peek() != null) {
            System.out.printf(queue.remove() + " ");
        }
        System.out.println();
    }

    static class Gen implements Generator<String> {

        String[] s = ("one two three four five six seven eight nine ten").split(" ");

        int i;

        @Override
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {

        // 普通链表队列
        test(new LinkedList<String>(), new Gen());

        // 优先级队列
        test(new PriorityQueue<String>(), new Gen());

        // 基于数组的并发阻塞队列
        test(new ArrayBlockingQueue<String>(count), new Gen());

        // 基于链表的并发队列
        test(new ConcurrentLinkedDeque<String>(), new Gen());

        // 基于链表的FIFO阻塞队列
        test(new LinkedBlockingDeque<String>(), new Gen());

        // 带优先级的无界阻塞队列
        test(new PriorityBlockingQueue<String>(), new Gen());

        // 延期阻塞队列
        // DelayQueue

        // 基于链表的FIFO双端阻塞队列
        // LinkedBlockingDeque

        // 并发同步阻塞队列
        // SynchronousQueue
    }
}
