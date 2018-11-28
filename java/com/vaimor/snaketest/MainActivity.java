package com.vaimor.snaketest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public SnakeView snakeView;
    private final Handler handler = new Handler();

    private float prevX=100, prevY=100;

    private float h,w;
    int currentDir=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        snakeView=  new SnakeView(this);
        setContentView(snakeView);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        this.h=height;
        this.w=width;
        snakeView.foodForSnake(w,h);
        snakeView.setOnTouchListener(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,500);
                snakeView.foodcheker();
                snakeView.update(currentDir);
                snakeView.invalidate();

            }
        },500);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
               // this.prevX = event.getX();
               // this.prevY = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                float newX = event.getX();
                float newY = event.getY();

                if(Math.abs(newX - this.prevX)/this.w > Math.abs(newY - this.prevY)/this.h) {
                    //LEFT - RIGHT direction

                    if ((newX - this.prevX)<0){
                        snakeView.update(1);
                        this.currentDir=1;
                    }else {
                        snakeView.update(2);
                        this.currentDir=2;

                    }
                }else{
                    // UP= DOWN direction
                    if((newY - this.prevY)<0) {
                        snakeView.update(3);
                        this.currentDir=3;

                    }else{
                        snakeView.update(4);
                        this.currentDir=4;

                    }
                }

                this.prevX=newX;
                this.prevY=newY;
        }

        return true;
    }



}