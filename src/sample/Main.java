package sample;


import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.*;

import java.util.Random;

public class Main extends Application {
    private boolean gameRunning;

    private static final int width = 600;
    private static final int height = 600;
    private static final int gridX = 20;
    private static final int gridY = 20;
    private static final int gridSize = width/gridX;

    private GraphicsContext gc;
    private int direction;
    private int score = 0;

    Random random = new Random();
    Stage window;
    Scene sceneMenu;
    Scene sceneGame;
    @Override
    public void start(Stage primaryStage) throws Exception{

        //Creates the necessary objects for the stage
        window = primaryStage;
        window.setTitle("--|Snake|--");
        window.setResizable(false);
        Canvas canvas = new Canvas(width,height);
        gc = canvas.getGraphicsContext2D();
        Group groupScene2 = new Group();
        groupScene2.getChildren().add(canvas);

        //Handles the starting Menu scene
        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> window.setScene(sceneGame));
        StackPane menuLayout = new StackPane();
        menuLayout.getChildren().add(startButton);
        sceneMenu = new Scene(menuLayout,width/2,height/2);

        //Handles the main Game scene
        Label scoreLabel = new Label("Score: "+ score);
        HBox topBox = new HBox();
        topBox.getChildren().add(scoreLabel);
        BorderPane border = new BorderPane();
        border.setTop(topBox);

        food foodUnit = new food(0,0);
        foodUnit.move(random,gridSize,gridX,gridY);
        Snake snake = new Snake();
        SnakeSection snakeSection = new SnakeSection(gridSize,gridSize);
        snakeSection.moveDirection(SnakeSection.Direction.up);
        snake.addSection(gridSize);
        groupScene2.getChildren().addAll(foodUnit,snakeSection);
        border.setCenter(groupScene2);
        sceneGame = new Scene(border);

        //Game starts on the Menu scene
        window.setScene(sceneMenu);
        window.show();
        drawGame.drawGrid(gridX,gridY,gridSize,gc);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
