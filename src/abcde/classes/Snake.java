package abcde.classes;

public class Snake {
    public static long hiss = 2;

    public static void main(String[] args) {
        Snake snake = new Snake();
        System.out.println(snake.hiss);
        snake.hiss = 123;
        System.out.println(snake.hiss);

    }
}
