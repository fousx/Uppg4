package sample;

import java.util.ArrayList;

/**
 * A class representing the player snake as an ArrayList of multiple SnakeSections.
 *
 */
public class Snake{
    private ArrayList<SnakeSection> snakeBody;
    int x,y;
    Snake(){
        snakeBody = new ArrayList<SnakeSection>();
    }
    public void eat(int gridSize){
        addSection(gridSize);
    }
    public void addSection(int gridSize){
        //Head of snake
        if(snakeBody.isEmpty()){
            snakeBody.add(new SnakeSection(gridSize,gridSize));
        }
        //Rest of snake
        else{
            SnakeSection newSection = new SnakeSection(gridSize,gridSize);
            newSection.setPosition(gridSize,x,y);
            snakeBody.add(newSection);
        }
    }
}
