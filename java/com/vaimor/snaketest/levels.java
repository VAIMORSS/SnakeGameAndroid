package com.vaimor.snaketest;


public class levels{

    int[] x,y;
    int swidth, sheight;

    widthSetter widthsetter = new widthSetter();
    int width = widthsetter.width;
    int numberOfblock;



    public levels(){

        numberOfblock=0;

    }

    public void setSheight(int x, int y){
        this.sheight=y;
        this.swidth=x;
    }

    public void makingNullFree(int length){
        x= new int[length];
        y= new int[length];
        for(int i=0; i<x.length;i++){
            x[i]=0;
            y[i]=0;
        }
    }

    public void level1(){
        numberOfblock=16;
        makingNullFree(numberOfblock);
        x[0]=width*3;
        y[0]=width*6;
        for(int i=1; i<x.length;i++){

            if(i==9){
                x[i-1]=width*3;
            }
            x[i]=x[i-1]+width;

        }
        for(int j=1; j<y.length;j++){
            if(j<8){
                y[j]=width*6;
            }
            else{
                y[j]=width*12;
            }

        }
    }

    public void level2(){
        numberOfblock=26;
        makingNullFree(numberOfblock);
        x[0]=swidth/2;
        int xh=0;
        y[0]=0;
        for(int i=1; i<x.length;i++){

            if(i<21){
                x[i]=x[0];
                y[i]=y[i-1]+width;
            }else if(i<26){
                x[i]=xh;
                xh+=width;
                y[i]=sheight/2;
            }

        }

    }
    public void level3(){


    }

}
