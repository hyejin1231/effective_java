package chapter01.item07.executor;

import java.util.concurrent.*;

/**
 * item07. 다 쓴 객체 참조를 해제하라.
 * 완벽공략 - Executor
 */
public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfCpu = Runtime.getRuntime().availableProcessors(); // cpu intensive 할 때
        ExecutorService service1 = Executors.newCachedThreadPool(); // 없으면 스레드를 생성하기 때문에 자원 낭비의 가능성이 있어서 조심히 사용해야함
        ExecutorService service2 = Executors.newSingleThreadExecutor(); // 굉장히 비효율적
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        // 만약 100개의 작업이 필요하다면?
        // -> ExecutorService 활용 (ex. 10개의 Thread를 생성해서)
        // -> 스레드 풀 개수 중요
        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            service.submit(new Task());
//        }

//        Thread thread = new Thread(new Task());
//        thread.start();
        Future<String> submit = service.submit(new CallableTask());


        System.out.println(Thread.currentThread() + " hello");

        System.out.println(submit.get());

        service.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread() + " world");
        }
    }

    // 결과를 받고 싶을 때 사용
    static class CallableTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            return Thread.currentThread() + " world";
        }
    }
}
