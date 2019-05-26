package companies.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class SortNumber {
    final static int list_size = 5000;
    final static int pool_size = 10;
    final static int bound = list_size *4;
    static List<Long> unsortedRandomNumber = new ArrayList<>();
    static List<Long> sortedRandomNumber = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        buildList(bound);
        System.out.println("printing unsorted list:" + unsortedRandomNumber);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newScheduledThreadPool(pool_size);
        List<Future<Long>> resultList = new ArrayList<>();
        try {
            for (int i = 0; i < list_size; i++) {
                resultList.add(tpe.submit(new RemoveAndInsert()));
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        for (Future<Long> f : resultList) {
            try {
                f.get();
//                System.out.println("Future result is - " + " - " + f.get() + "; And Task done is " + f.isDone());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        tpe.shutdown();
        System.out.println("printing sorted list:" + sortedRandomNumber);
    }

    static class RemoveAndInsert implements Callable<Long> {
        @Override
        public Long call() {
//            String threadName = Thread.currentThread().getName();
            Long insert = unsortedRandomNumber.remove(0);// remove the first element
//            System.out.println("RemoveAndInsert run unsorted[" + threadName + "]" + insert);
            insert(insert);
            return null;
        }

        synchronized private void insert(Long insert) {
            if (sortedRandomNumber.size() == 0) {
                sortedRandomNumber.add(insert);
            } else {
                int start = 0;
                for (; start < sortedRandomNumber.size(); start++) {
                    if (sortedRandomNumber.get(start) > insert) {
                        break;
                    }
                }
                sortedRandomNumber.add(start, insert);
            }
        }
    }

    private static void buildList(int bound) throws ExecutionException, InterruptedException {
        int cnt = 0;
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newScheduledThreadPool(pool_size);
        while (cnt++ < list_size) {
            Future<Long> f = tpe.submit(new RandomNumberEmitter(bound));
            unsortedRandomNumber.add(f.get());
        }
        tpe.shutdown();
    }
}
