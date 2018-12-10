package com.vaimor.snaketest;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;


public class SnakePortions {


    public Rect snakePortion;
    int dir;
    int x,y,width;
    widthSetter widthsetter= new widthSetter();



    public SnakePortions(){

        this.dir=1;
        this.x=100;
        this.y=100;
        width= widthsetter.width;
    }

    public void setter(int x, int y){
        this.x=x;
        this.y=y;
        snakePortion= new Rect(this.x,this.y,this.x+width,this.y+width);
    }

    public void setter(){
        snakePortion= new Rect(this.x,this.y,this.x+width,this.y+width);
    }


}
