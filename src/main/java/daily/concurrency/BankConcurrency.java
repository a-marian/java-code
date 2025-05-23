package daily.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class BankConcurrency {

    private Lock vault = new ReentrantLock();
    private int total=0;

    public void deposit( int value){
        try{
            vault.tryLock();
            total += value;
        } finally{
            vault.unlock();
        }
    }

    public static void main(String[] args) {
        var bank = new BankConcurrency();
        IntStream.range(1,10).parallel().forEach(s -> bank.deposit(s));
        System.out.println(bank.total);
    }
}
