package com.sy.world;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class sssz {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new GetYcBalanceTask(Collections.singletonList("121")));
        Thread thread = new Thread(futureTask);
        thread.start();

        String integer;
        try {
            integer = futureTask.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            thread.interrupt();
            throw new RuntimeException(e);
        }

        System.out.println(integer);
    }

    static class GetYcBalanceTask implements Callable<String> {
        private final List<String> accounts;

        public GetYcBalanceTask(List<String> accounts) {
            this.accounts = accounts;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            System.out.println("22222222");
            return "12321";
        }
    }
}

