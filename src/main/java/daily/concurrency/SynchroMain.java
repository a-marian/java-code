package daily.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SynchronizedExample {
    private int count=0;

    public synchronized void increment(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }

    public void demo(){
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Synchronized count: "+ getCount());
    }
 }
 class LockExample {

     private int count=0;
     private Lock lock = new ReentrantLock();
     private Condition condition = lock.newCondition();

     public void increment(){
         lock.lock();
         try{
             count++;
         } finally {
             lock.unlock();
         }
     }

     public int getCount(){
         lock.lock();
         try {
             return count;
         } finally {
             lock.unlock();
         }
     }
     public void awaitSignal() throws InterruptedException {
         lock.lock();
         try{
             condition.await();
         } finally {
             lock.unlock();
         }
     }

     public void signalAll(){
        lock.lock();
        try{
            condition.signalAll();
        }finally {
            lock.unlock();
        }
     }

     public void demo(){
         Thread t1 = new Thread(() -> {
             for (int i = 0; i < 1000; i++) {
                 increment();
             }
         });

         Thread t2 = new Thread(() -> {
             for (int i = 0; i < 1000; i++) {
                 increment();
             }
         });
         t1.start();
         t2.start();

         try {
             t1.join();
             t2.join();
         } catch (InterruptedException e){
             Thread.currentThread().interrupt();
         }

         System.out.println("Lock count: "+ getCount());
     }

     public void conditionDemo() throws InterruptedException {
         Thread waiter = new Thread(() ->{
             try {
                 System.out.println("Waiter is waiting...");
                 awaitSignal();
                 System.out.println("Waiter is signaled.");
             } catch (InterruptedException e){
                 Thread.currentThread().interrupt();
             }
         });

         Thread signaler = new Thread(() -> {
             try{
                 Thread.sleep(1000); //Simulate some work
                 System.out.println("Signaler is signaling...");
                 signalAll();
             } catch (InterruptedException e){
                 Thread.currentThread().interrupt();
             }
         });

         waiter.start();
         signaler.start();

         waiter.join();
         signaler.join();

         System.out.println("Condition demo finished.");
     }
 }

 public class SynchroMain {

     public static void main(String[] args) throws InterruptedException {
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        synchronizedExample.demo();

        LockExample lockExample = new LockExample();
        lockExample.demo();
        lockExample.conditionDemo();
     }

 }
