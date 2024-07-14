package highperfo.atm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Customer {

    public void withdraw(BankAccount account, int amount) {
        int balance = account.getBalance();
        if (balance - amount < 0) {
            System.out.println("Transaction denied");
        } else {
            System.out.println("Handling transaction...");
            account.debit(amount);
            System.out.println("$" + amount + " withdrawn");
        }
        System.out.println("Current balance: " + account.getBalance());
    }

    public static void usingExecutorService() {
        ATM atm = new ATM();
        BankAccount account = new BankAccount();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> atm.withdraw(account, 100));
        executorService.submit(() -> atm.withdraw(account, 100));

        executorService.shutdown();
    }
}
