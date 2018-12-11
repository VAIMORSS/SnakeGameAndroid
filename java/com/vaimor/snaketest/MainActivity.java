package com.vaimor.snaketest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public SnakeView snakeView;
    private final Handler handler = new Handler();
    int l;
    int speed=500;
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

        snakeView.foodForSnake((int)w,(int)h);
        snakeView.setOnTouchListener(this);
        l=0;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(snakeView.flag){
                    handler.postDelayed(this,speed);
                    if(snakeView.snake.size()>0){
                    snakeView.foodcheker();
                    snakeView.update(currentDir);
                    }

                    snakeView.invalidate();
                }else{
                   // Log.d("In else"," : YES");
                    handler.postDelayed(this,1000);

                    l++;
                    if(l>2){
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "You lost New game starting in few second",
                                Toast.LENGTH_SHORT);

                        toast.show();
                        snakeView.resetgame();
                        snakeView.flag=true;
                        l=0;
                    }
                }


            }
        },500);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                float newX = event.getX();
                float newY = event.getY();

                 if (Math.abs(newX - this.prevX) / this.w > Math.abs(newY - this.prevY) / this.h) {
                    //LEFT - RIGHT direction

                    if ((newX - this.prevX) < 0 && this.currentDir!=2) {
                        snakeView.update(1);//left
                        this.currentDir = 1;
                    } else if( (newX - this.prevX) > 0 && this.currentDir!=1){
                        snakeView.update(2);//right
                        this.currentDir = 2;

                    }
                } else {
                    // UP= DOWN direction
                    if ((newY - this.prevY) < 0 && this.currentDir!=4) {
                        snakeView.update(3);//up
                        this.currentDir = 3;

                    } else if((newY - this.prevY) > 0 && this.currentDir!=3){
                        snakeView.update(4);//down
                        this.currentDir = 4;

                    }
                }

                this.prevX = newX;
                this.prevY = newY;
        }

        return true;
    }



}
