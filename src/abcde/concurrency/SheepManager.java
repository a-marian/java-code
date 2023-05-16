package abcde.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {

    private int sheepCount = 0;

    void incrementAndReport(){
        System.out.println((++sheepCount)+" ");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try{
            SheepManager sheepManager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                executorService.submit(sheepManager::incrementAndReport);
            }
        } finally {
            executorService.shutdown();
        }
    }
}
