package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class food extends Circle{
    food(int x,int y){
        super(x,y,10);
        this.setFill(Color.web("#e3280b"));
    }
    public void move(Random rand,int gridSize,int gridX,int gridY){
        int x,y;
        x = rand.nextInt(gridX)*gridSize+gridSize/2;
        y = rand.nextInt(gridY)*gridSize+gridSize/2;
        this.setLayoutX((double) x);
        this.setLayoutY((double) y);
    }
}
