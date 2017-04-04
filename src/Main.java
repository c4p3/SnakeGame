import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{

    Snake snek;

    public Main(){
        snek = new Snake(100,100,20,20);
    }

    public static void main(String[] args) {
	    launch(args);
    }


    @Override
    public void start(Stage primaryStage){
        Group root = new Group();

        Thread game = new Thread(snek);
        game.start();


        root.getChildren().addAll(snek);
        Scene scene = new Scene(root, 500, 500, Color.BLACK);
        scene.setOnKeyPressed(keyListener);
        primaryStage.setScene(scene);
        primaryStage.show();


        //Slukker snek når vi lukker vindue
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                snek.toogleRunning();
                Platform.exit();
                System.exit(0);
            }
        });
    }

    final EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>()
    {
                public void handle(final KeyEvent keyEvent)
                {
                    if (keyEvent.getCode() == KeyCode.UP)
                    {
                        snek.setDirection("up");
                        System.out.println("up");
                    }
                    if (keyEvent.getCode() == KeyCode.DOWN)
                    {
                        snek.setDirection("down");
                        System.out.println("down");
                    }
                    if (keyEvent.getCode() == KeyCode.LEFT)
                    {
                        snek.setDirection("left");
                        System.out.println("left");
                    }
                    if (keyEvent.getCode() == KeyCode.RIGHT)
                    {
                        snek.setDirection("right");
                        System.out.println("right");
                    }
                }

            };



}
