package com.vaimor.snaketest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Snake {

    int snakePortionsNumber;
    SnakePortions fullSnake[];
    Paint snakePaint;

    public Snake(){
        this.snakePortionsNumber=1;
        snakePaint = new Paint();
        fullSnake = new SnakePortions[snakePortionsNumber];

        for(int i=0;i<snakePortionsNumber;i++){
            fullSnake[i] = new SnakePortions();
        }
        fullSnake[0].x=this.snakePortionsNumber*100;
    }

    public void gotFood(int dir){
        this.snakePortionsNumber++;
    }


    public void fullSnakeMaker(Canvas canvas){

        snakePaint.setColor(Color.BLUE);
        for(int i=0;i<snakePortionsNumber;i++){
            canvas.drawRect(fullSnake[i].snakePortion,snakePaint);
        }

    }

}
