package com.vaimor.snaketest;

import android.graphics.Rect;

public class SnakePortions {


    public Rect snakePortion;
    int dir;
    int x,y;


    public SnakePortions(){
        this.dir=1;
        this.x=100;
        this.y=100;
    }

    public void setter(int x, int y){
        this.x=x;
        this.y=y;
        snakePortion= new Rect(this.x,this.y,this.x+100,this.y+100);
    }

    public void setter(){
        snakePortion= new Rect(this.x,this.y,this.x+100,this.y+100);
    }


}
