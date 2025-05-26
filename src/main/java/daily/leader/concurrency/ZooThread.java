package daily.leader.concurrency;

public class ZooThread {

    public static void pause(){
        try{
            Thread.sleep(10_000);
        }catch (InterruptedException e){
            System.out.println("exception: " + e.getCause());
        }
        System.out.println("Thread finished!");
    }

    public static void main(String[] args) {
        var job = new  Thread(() -> pause()); // create a thread
        job.start(); // Start thread
        System.out.println("Main method finished!");
    }
}
