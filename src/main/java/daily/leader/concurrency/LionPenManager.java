package daily.leader.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class LionPenManager {

    private void removeLions(){
        System.out.println("Removing lions");
    }
    private void cleanPen(){
        System.out.println("Clean pen");
    }
    private void addLions(){
        System.out.println("Adding lions");
    }
    private void performTask(){
        removeLions();
        cleanPen();
        addLions();
    }
    private void performTaskCyclicBarrier(CyclicBarrier c1, CyclicBarrier c2){
        try {
            removeLions();
            c1.await();
            cleanPen();
            c2.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        addLions();
    }

    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(4);
        try{
            var manager = new LionPenManager();
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTask());
            }
            // Cyclic Barrier
            //var c1 = new CyclicBarrier(4);
            //var c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
           // for (int i = 0; i < 4; i++) {
             //   service.submit(() -> manager.performTaskCyclicBarrier(c1, c2));
           // }
        } finally {
            service.shutdown();
        }
    }



}
