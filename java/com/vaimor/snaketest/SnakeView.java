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
    int x=100;
    int y=100;
    int width = 100;

    public Rect rect,foodr;
    public Paint paint;
    food f= new food();
    List<SnakePortions> snake = new ArrayList<SnakePortions>();


    public SnakeView(Context context){
        super(context);
        snake.add(tempSnakeMaker(100,100));


    }

    public SnakePortions tempSnakeMaker(int x, int y){
        SnakePortions tempSnake= new SnakePortions();
        tempSnake.setter(x,y);
        return tempSnake;
    }


    public void updater(){
        for(int j=snake.size()-1;j>1;j--){
            snake.get(j).x=snake.get(j-1).x;
            snake.get(j).y=snake.get(j-1).y;
            snake.get(j).setter();
        }
    }

    public void foodcheker(){

        if(snake.get(0).x-f.x <100 && snake.get(0).y-f.y <100 && f.x-this.snake.get(0).x <100 && f.y-this.snake.get(0).y <100) {


            snake.add(0,tempSnakeMaker(f.x,f.y));// here this value should be assign to the firtst
            System.out.println(f.x+"     "+f.y);

            //when ever I add something i need to change the newx partameter as per thge diretion plus the directtin should have
        }





    }

    public void update(int i){
        for(int j=snake.size()-1;j>0;j--){
            snake.get(j).x=snake.get(j-1).x;
            snake.get(j).y=snake.get(j-1).y;}

        switch (i){
            case 1:

                    snake.get(0).x-=width; //LEFT

                break;
            case 2:

                    snake.get(0).x+=width; //RIGHT

                break;
            case 3:

                    snake.get(0).y-=width; //UP

                break;
            case 4:

                    snake.get(0).y+=width; //DOWN

                break;
        }
      ///  updater();
        snake.get(0).setter();
        for(int j=snake.size()-1;j>0;j--){
            snake.get(j).setter();
        }



    }

    public void foodForSnake(float w, float h){
        f.foodSetter(w,h);
    }

    @Override
    public void onDraw(Canvas canvas){
        System.out.println(snake.size()+"?????????????");
        super.onDraw(canvas);
        paint = new Paint();
        rect = new Rect(x,y,x+width,y+width);
        paint.setColor(Color.BLUE);
        canvas.drawColor(Color.WHITE);
        canvas.drawRect(f.food,f.foodPaint);
        for(int k=0;k<snake.size();k++){
            System.out.println(snake.get(k).x+"      "+snake.get(k).y);
            canvas.drawRect(snake.get(k).snakePortion,paint);
        }
       // canvas.drawRect(rect,paint);


    }

}
