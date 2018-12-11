package com.vaimor.snaketest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class SnakeView extends View {

    int screenWidth, screenHeight, score=0;
    boolean flag=true;
    widthSetter widthsetter = new widthSetter();
    int width = widthsetter.width;
    int x = width * 2;
    int y = width * 2;
    String onOut=" ";
    int levelNo=0,speed=500;
    Drawable wall = getResources().getDrawable(R.drawable.border_cell);
    Drawable snakeImage = getResources().getDrawable(R.drawable.snake);
    Drawable foodImage = getResources().getDrawable(R.drawable.food);
    public levels level= new levels();


    public Rect rect, foodr;
    public Paint paint = new Paint();
    public Paint paintForScore = new Paint();
    public Paint paintForLevel = new Paint();

    food f = new food();
    List<SnakePortions> snake = new ArrayList<SnakePortions>();

    public void resetgame(){
        resetSnake();
        score=0;
        level.reset();
    }

    public void resetSnake(){
        snake.clear();
        snake.add(tempSnakeMaker(100, 100));
    }

    public void gameOut(){
        for(int i=0;i<level.numberOfblock;i++){
         //   Log.d("dim",snake.get(0).x+" "+snake.get(0).y+" "+level.x[i]+" "+level.y[i]);
            if(snake.get(0).x - level.x[i] < width && snake.get(0).y - level.y[i] < width && level.x[i] - this.snake.get(0).x < width && level.y[i] - this.snake.get(0).y < width){
                flag=false;
            }
        }


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
        level.setSheight(w,h);
    }

    public void foodcheker() {

        if (snake.get(0).x - f.x < width && snake.get(0).y - f.y < width && f.x - this.snake.get(0).x < width && f.y - this.snake.get(0).y < width) {
            snake.add(0, tempSnakeMaker(f.x, f.y));
            //System.out.println(f.x + "     " + f.y);
            f.foodSetter();
            score++;
        }
        if(score>2){
            level.level1();
            this.speed=400;
            levelNo=1;
        }else if(score>5){
            level.level2();
            this.speed=350;
            levelNo=2;
        }else if(score>9){
            level.reset();
            levelNo=3;
            this.speed=300;
        }else if(score>13){
            level.level1();
            levelNo=4;
            this.speed=250;
        }else if(score > 16){
            level.level2();
            this.speed=200;
            levelNo=5;
        }else if(score >19){
            level.reset();
            levelNo=6;
            this.speed=150;
        }else if(score>22){
            levelNo=7;
            level.level1();
            this.speed=100;
        }else if(score>24){
            level.level2();
            levelNo=8;
            this.speed=50;
        }


    }

    public void update(int i) {
        if(score>0){
            gameOut();
        }

        for (int j = snake.size() - 1; j > 0; j--) {
            snake.get(j).x = snake.get(j - 1).x;
            snake.get(j).y = snake.get(j - 1).y;
        }

        //System.out.println("size  :  "+snake.size());
        if(snake.get(0).x>=screenWidth){
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


    public void onOutText(String s){
        this.onOut=s;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect = new Rect(x, y, x + width, y + width);
        paint.setColor(Color.BLUE);
        paintForScore.setColor(Color.BLACK);
        paintForLevel.setColor(Color.RED);

        canvas.drawColor(Color.WHITE);

        foodImage.setBounds(f.x,f.y,f.x+width,f.y+width);
        foodImage.draw(canvas);

        paintForScore.setTextSize(75);
        paintForLevel.setTextSize(75);

        canvas.drawText("Score : "+ String.valueOf(score),100,100, paintForScore);
        canvas.drawText("Level : "+ String.valueOf(levelNo),1100,100, paintForLevel);

        if(!flag){
            canvas.drawText(onOut,100,100,paintForScore);
        }

        for (int k = 0; k < snake.size(); k++) {
            //canvas.drawRect(snake.get(k).snakePortion, paint);
            snakeImage.setBounds(snake.get(k).x,snake.get(k).y,snake.get(k).x+width,snake.get(k).y+width);
            snakeImage.draw(canvas);
        }

        for(int i=0;i<level.numberOfblock;i++){
            wall.setBounds(level.x[i],level.y[i],level.x[i]+width,level.y[i]+width);
            wall.draw(canvas);
        }

    }
}
