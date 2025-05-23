package daily.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BedTime {

    private AtomicInteger s1 = new AtomicInteger(0);
    private int s2 = 0;

    private void countSheep() throws InterruptedException{
        var service = Executors.newSingleThreadExecutor();
        try{
            for (int i = 0; i < 100; i++) {
                service.execute(() -> {
                    s1.getAndIncrement();
                    s2++;
                });
                Thread.sleep(60*1000);
                System.out.println(s1+" "+s2);
            }
        }finally{
            service.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new BedTime().countSheep();
    }
}
