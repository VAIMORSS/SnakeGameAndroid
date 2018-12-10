package com.vaimor.snaketest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SnakeView extends View {

    int screenWidth, screenHeight;
    widthSetter widthsetter = new widthSetter();
    int width = widthsetter.width;
    int x = width * 2;
    int y = width * 2;


    public Rect rect, foodr;
    public Paint paint = new Paint();
    public Paint paintForWall = new Paint();
    food f = new food();
    List<SnakePortions> snake = new ArrayList<SnakePortions>();



    public void wallMaker(){

    }
    public SnakeView(Context context) {
        super(context);
        snake.add(tempSnakeMaker(100, 100));
    }

    public SnakePortions tempSnakeMaker(int x, int y) {
        SnakePortions tempSnake = new SnakePortions();
        tempSnake.setter(x, y);
        return tempSnake;
    }

    public void foodForSnake(int w, int h) {
        f.widthHeightSetter(w, h);
        f.foodSetter();
        this.screenWidth = w;
        this.screenHeight = h;

    }

    public void foodcheker() {

        if (snake.get(0).x - f.x < width && snake.get(0).y - f.y < width && f.x - this.snake.get(0).x < width && f.y - this.snake.get(0).y < width) {
            snake.add(0, tempSnakeMaker(f.x, f.y));
            System.out.println(f.x + "     " + f.y);
            f.foodSetter();
        }

    }

    public void update(int i) {
        for (int j = snake.size() - 1; j > 0; j--) {
            snake.get(j).x = snake.get(j - 1).x;
            snake.get(j).y = snake.get(j - 1).y;
        }

        
        if(snake.get(0).x>screenWidth){
            snake.get(0).x=0;
        }if(snake.get(0).x<0){
            snake.get(0).x=screenWidth;
        }if(snake.get(0).y>screenHeight){
            snake.get(0).y=0;
        }if(snake.get(0).y<0){
            snake.get(0).y=screenHeight;
        }
        switch (i) {
            case 1:

                snake.get(0).x -= width; //LEFT

                break;
            case 2:

                snake.get(0).x += width; //RIGHT

                break;
            case 3:

                snake.get(0).y -= width; //UP

                break;
            case 4:

                snake.get(0).y += width; //DOWN

                break;
        }

        snake.get(0).setter();
        for (int j = snake.size() - 1; j > 0; j--) {
            snake.get(j).setter();
        }

    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect = new Rect(x, y, x + width, y + width);
        paint.setColor(Color.BLUE);
        paintForWall.setColor(Color.GREEN);
        canvas.drawColor(Color.WHITE);
        canvas.drawRect(f.food, f.foodPaint);
        for (int k = 0; k < snake.size(); k++) {
            canvas.drawRect(snake.get(k).snakePortion, paint);
        }

        int xW=0,yW=0;
        while(xW<screenWidth){
            canvas.drawCircle(xW,0,width/2,paintForWall);
            canvas.drawCircle(xW,screenHeight-4*width,width/2,paintForWall);
            xW+=width;
        }
        while(yW<screenHeight){
            canvas.drawCircle(0,yW-width,width/2,paintForWall);
            canvas.drawCircle(screenWidth,yW,width/2,paintForWall);
            yW+=width;
        }

    }
}
