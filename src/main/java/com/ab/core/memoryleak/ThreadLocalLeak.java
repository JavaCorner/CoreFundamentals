package com.ab.core.memoryleak;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author Arpit Bhardwaj
 */
public class ThreadLocalLeak {
    private static final int POOL_SIZE = 50;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < POOL_SIZE; i++) {
            Future future = threadPool.submit(new LeakingAction());
            futureList.add(future);
        }
        for (Future future:
             futureList) {
            System.out.println(future.get());
        }

        System.out.println("Work Complete");

    }

    private static class LeakingAction implements Callable {
        private static final String PAD = "AAAAA";
        private static final int SIZE = 128 * 1024 / (PAD.length() + 1);

        private static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() ->
                LongStream.range(0,SIZE)
                .mapToObj(i -> PAD + i)
                .collect(Collectors.joining()));

        @Override
        public Object call() throws Exception {
            final String value = threadLocal.get();
            threadLocal.remove();//to avoid thread local leak
            return value.length();
        }
    }
}
