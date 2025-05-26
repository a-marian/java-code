package daily.leader.concurrency;

public class ThreadMain {

    public static void main(String[] args) {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: "+ i);
            }
        };
    }
}
