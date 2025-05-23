package daily.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class PrintCounter {

    static int count=0;

    public static void main(String[] args) {
        var service = Executors.newSingleThreadExecutor();
        try{
            var r= new ArrayList<Future<?>>();
            IntStream.iterate(0, i-> i+1).limit(5).forEach(
                    i -> r.add(service.submit(()-> {count++;}))
            );
        } finally {
            service.shutdown();
        }
    }
}
