package companies.hw;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RandomNumberEmitter implements Callable<Long> {
    int bound;

    public RandomNumberEmitter(int bound) {
        this.bound = bound;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int cnt = 0;
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newScheduledThreadPool(5);
        while (cnt++ < 100) {
            Thread.sleep(10);
            tpe.submit(new RandomNumberEmitter(100));
        }
        tpe.shutdown();
    }

    @Override
    public Long call() {
        String threadName = Thread.currentThread().getName();
        Long l = Long.valueOf(new Random().nextInt(bound));
//        System.out.println("Emitter.call [" + threadName + "]:" + l);
        return l;
    }
}
