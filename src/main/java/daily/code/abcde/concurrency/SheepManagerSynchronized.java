package abcde.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerSynchronized {
    private static int count = 0;

    private void incrementAndReport(){
        synchronized (this){
            System.out.print((++count)+" ");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            var manager = new SheepManager();
            for(int i=0; i < 10; i++)
                executorService.submit(manager::incrementAndReport);
        } finally {
            executorService.shutdown();
        }
    }
}
