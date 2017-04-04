import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StartButton extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

       /* HBox h1 = new HBox(30);
        Label startLabel = new Label("Welcome to snek game");
        startLabel.setStyle("-fx-background-color: chartreuse");
        h1.setHgrow(startLabel, Priority.ALWAYS);*/


        HBox hbox = new HBox();
        Button startBtn = new Button("START");
        startBtn.setStyle("-fx-background-color: #007e00; ");
        HBox.setHgrow(startBtn, Priority.ALWAYS);
        startBtn.setMaxWidth(100);
        startBtn.setMaxHeight(60);
        //Skal finde scene fra Main.java?
       startBtn.setOnAction( e ->
               System.out.println("Button clicked"));




        StackPane stack = new StackPane();
        stack.setStyle("-fx-background-color: black");
        Scene startScene = new Scene(stack, 500,500, Color.BLACK);
        stack.getChildren().addAll( startBtn);



        primaryStage.setScene(startScene);
        primaryStage.setTitle("Snek game");
        primaryStage.show();
    }

}
