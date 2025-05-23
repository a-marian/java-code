package daily.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StockRoomTracker {

    public static void await(CyclicBarrier cb){
        try{cb.await(10, TimeUnit.SECONDS);
        } catch (Exception e){}
    }

    public static void main(String[] args) {
        var cb = new CyclicBarrier(10, () -> System.out.println("Stock Room Fulll!"));
        IntStream.iterate(1, i -> 1).limit(9).parallel()
                .forEach(i -> await(cb));
    }
}
