package com.vaimor.snaketest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;

public class food {

    int x,y,screenHeight,screenWidth,width;
    Rect food;
    Paint foodPaint;

    widthSetter widthsetter= new widthSetter();

    public food(){
        this.x=0;
        this.y=0;
        this.width=widthsetter.width;
        foodPaint= new Paint();
        foodPaint.setColor(Color.RED);
    }

    public void widthHeightSetter(float w, float h){
        this.screenWidth=(int)w;
        this.screenHeight=(int)h;
    }

    public void foodSetter(){
        this.x= (int)(Math.random()*(screenWidth-2*width)+width);
        this.y= (int)(Math.random()*(screenHeight-7*width)+width);
        this.x=this.x-(this.x%width);
        this.y=this.y-(this.y%width);
        food = new Rect(this.x,this.y,this.x+width,this.y+width);
    }





}
