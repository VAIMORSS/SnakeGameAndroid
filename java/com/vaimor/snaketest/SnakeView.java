package com.vaimor.snaketest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class SnakeView extends View {

    int x=100;
    int y=100;
    int width = 100;

    public Rect rect;
    public Paint paint;


    public SnakeView(Context context){
        super(context);


    }

    public void update(int i){


        switch (i){
            case 1:
                this.x-=width; //LEFT
                break;
            case 2:
                this.x+=width; //RIGHT
                break;
            case 3:
                this.y-=width; //UP
                break;
            case 4:
                this.y+=width; //DOWN
                break;


        }
        }



    @Override
    public void onDraw(Canvas canvas){

        super.onDraw(canvas);
        paint = new Paint();
        rect = new Rect(x,y,x+width,y+width);
        paint.setColor(Color.BLUE);
        canvas.drawColor(Color.WHITE);
        canvas.drawRect(rect,paint);
    }

}
