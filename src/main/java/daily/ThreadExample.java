package daily;

public class ThreadExample  implements Runnable{

    Thread t;
    ThreadExample(){
        t= new Thread(this, "New Thread");
        t.start();
    }
    @Override
    public void run() {
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t);
    }
}

class multithread_programing{
    public static void main(String... args) {
        new ThreadExample();
    }
}