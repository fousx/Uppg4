package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class SnakeSection extends Rectangle {
    private int gridSize,gridX = 10,gridY = 10;
    public enum Direction{
        right,
        left,
        up,
        down
    }
    //No direction at beginning
    private Direction direction = null;
    SnakeSection(int size,int _gridSize){
        super(size,size);
        gridSize=_gridSize;
        this.setFill(Color.web("#4a5bb0"));
    }
    public void setPosition(int _gridSize, int _gridX, int _gridY){
        int x,y;
        gridSize=_gridSize;
        gridX=_gridX;
        gridY=_gridY;
        x = gridX*gridSize-gridSize;
        y = gridY*gridSize-gridSize;
        this.setLayoutX((double) x);
        this.setLayoutY((double) y);
    }

    public void moveDirection(Direction _direction){
        switch (_direction){
            case up:
                setPosition(gridSize,gridX,gridY-1);
                break;
            case down:
                setPosition(gridSize,gridX,gridY+1);
                break;
            case right:
                setPosition(gridSize,gridX+1,gridY);
                break;
            case left:
                setPosition(gridSize,gridX-1,gridY);
                break;
        }
    }
}
