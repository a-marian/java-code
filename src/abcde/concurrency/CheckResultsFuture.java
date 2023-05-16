package abcde.concurrency;

import java.util.concurrent.*;

public class CheckResultsFuture {

    private static int counter = 0;

    public static void main(String[] args) throws ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try{
            Future<?> result = executorService.submit(() -> {
               for(int i=0; i < 1_000_000; i++) counter++;
            });
            result.get(10, TimeUnit.SECONDS); // return null for runnable
            System.out.println("Reached!");
        }catch (InterruptedException e){
            System.out.println("Not reached in time");
        } finally {
            executorService.shutdown();
        }
    }

}
