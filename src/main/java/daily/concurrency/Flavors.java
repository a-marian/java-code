package daily.concurrency;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Flavors {

    private static int counter;
    public static void countIceCreamFlavors(){
        counter=0;
        Runnable task=() -> counter++;
        LongStream.range(0,500).forEach(m -> new Thread(task).run());
        System.out.println(counter);
    }
    private void exampleTen(){
        List<Integer> lions = new ArrayList<>(List.of(1,2,3));
        List<Integer> tigers = new CopyOnWriteArrayList<>(lions);
        Set<Integer> bears = new ConcurrentSkipListSet<>();
        bears.addAll(lions);
        for (Integer item: tigers) {
            tigers.add(4);
        }
        for (Integer item: bears) {
            bears.add(5);
        }
        System.out.println(lions.size()+" "+tigers.size()+" "+bears.size());
    }
    public static void main(String[] args) {
        //countIceCreamFlavors();
        Integer i1 = Stream.of(1,2,3,4,5).findAny().get();
        synchronized (i1){
            Integer i2 = List.of(6,7,8,9,10).parallelStream().sorted().findAny().get();
            System.out.println(i1+" "+i2);
        }
    }
}
