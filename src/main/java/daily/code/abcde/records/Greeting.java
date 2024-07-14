package abcde.records;

public record Greeting<T>( T t) {
    public Greeting(T t){
        this.t = t;
    }

    private <T> void println(T message){
        System.out.println(t + "-" + message);
    }

    public static void main(String[] args) {
        new Greeting<String>("Good morning").println(1);
        new Greeting("Bom dia").println(true);
    }
}
