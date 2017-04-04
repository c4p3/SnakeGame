import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Snake extends Rectangle implements Runnable {

    private static final int MOVE_BY = 10;
    private String direction = "right";
    private boolean running = true;


    public Snake(int x, int y, int width, int height){
        super(x, y, width, height);
        setFill(Color.RED);

    }

    public void toogleRunning(){
        running = !running;
    }

    @Override
    public void run() {
        while(running){

            System.out.println("Snek is moving..");
            move();

            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void move(){
        TranslateTransition mover = new TranslateTransition(new Duration(10), this);

        switch(direction){
            case "up":
                mover.setByY(- MOVE_BY);
                break;
            case "down":  mover.setByY(MOVE_BY); break;
            case "left":  mover.setByX(- MOVE_BY); break;
            case "right":  mover.setByX(MOVE_BY); break;

        }

        mover.play();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String s) {
        this.direction = s;
    }
}
