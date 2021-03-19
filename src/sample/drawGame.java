package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class drawGame {
    public static void drawGrid(int gridX,int gridY, int gridSize, GraphicsContext gc){
        for(int i = 0; i < gridX; i++){
            for(int j = 0; j < gridY; j++){
                if((i+j)%2==0){
                    gc.setFill(Color.web("#29a349"));
                }
                else{
                    gc.setFill(Color.web("#22853c"));
                }
                gc.fillRect(i*gridSize, j*gridSize,gridSize,gridSize);
            }
        }
    }
}
