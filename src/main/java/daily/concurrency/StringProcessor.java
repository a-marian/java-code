package daily.concurrency;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StringProcessor {

    public static void main(String[] args) {
        // Sample list of strings
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "mango");
        long timeStart= System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        strings.forEach(str -> {
            executorService.submit(() -> {
               try{
                   System.out.println("Processing "+ str + " by " +  Thread.currentThread().getName());
                   Thread.sleep(1000); // simulate work
                   System.out.println("Completed " + str);
               } catch (InterruptedException e){
                   Thread.currentThread().interrupt();
                   System.out.println("Task interrumpted: " + e.getMessage());
               }
            });
        });
        System.out.println(System.currentTimeMillis() - timeStart + " time ms");
        //shutdown executor when all tasks are submitted
        executorService.shutdown();
        //wait for all task to complete
        try{
            if(!executorService.awaitTermination(60, TimeUnit.SECONDS)){
                executorService.shutdownNow();
                System.out.println("Executor did not terminate in the specified time");
            }
        } catch (InterruptedException e){
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            System.err.println("Shutdown interrumped: "+ e.getMessage());
        }

    }
}
