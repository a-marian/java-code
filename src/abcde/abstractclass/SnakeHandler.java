package abcde.abstractclass;

abstract class Snake{}
class Cobra extends Snake {
   public Cobra(String who) {
        System.out.println("I'm a "+ who);
    }
}
class GardenSnake extends Cobra {
    public GardenSnake(String who){
       super(who);
    }
}

public class SnakeHandler {
    private Snake snake;

    public void setSnake(Snake mySnake){
        this.snake = mySnake;
    }

    public static void main(String[] args) {
        new SnakeHandler().setSnake(new Cobra("cobra"));
        new SnakeHandler().setSnake(new GardenSnake("garden snake")); // print by
        new SnakeHandler().setSnake(null);
    }
}
