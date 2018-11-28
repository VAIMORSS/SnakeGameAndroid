package com.vaimor.snaketest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class food {

    int x,y,width;
    Rect food;
    Paint foodPaint;

    public food(){
        this.x=0;
        this.y=0;
        this.width=100;
        foodPaint= new Paint();
        foodPaint.setColor(Color.RED);
    }

    public void foodSetter(float mX,float mY){
        //this.x= (int)(Math.random()*(mX));
        //this.y= (int)(Math.random()*(mY));

        //this.x=this.x-(this.x%100);
        //this.y=this.y-(this.y%100);
        this.x=500;
        this.y=500;
        food = new Rect(this.x,this.y,this.x+width,this.y+width);
    }

    public void draw(Canvas canvas){
        canvas.drawRect(food,foodPaint);
    }




}
