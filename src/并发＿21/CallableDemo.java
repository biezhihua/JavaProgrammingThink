package 并发＿21;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by biezhihua on 16-7-6.
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(new TaskWithResult(i)));
            System.out.println(futures.get(i).isDone());
        }
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }

}


class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}