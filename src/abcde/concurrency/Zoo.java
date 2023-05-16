package abcde.concurrency;

public class Zoo {

    public static void pause(){
        try{
            Thread.sleep(10_000);
        } catch (InterruptedException e){}
        System.out.println("Thread finished!");
    }

    public static void main(String[] args) {
        var job = new Thread(Zoo::pause);
        job.start();
        System.out.println("Main method thread");
    }
}
