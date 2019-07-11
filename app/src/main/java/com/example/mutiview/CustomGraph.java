package com.example.mutiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomGraph extends SurfaceView implements SurfaceHolder.Callback {
    public SurfaceHolder surfaceHolder =null;
    private Paint paint = null;
    private float m,b;

    public CustomGraph(Context context){
        super(context);
        paint=new Paint();
        paint.setColor(Color.RED);
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder){

    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2){

    }
    @Override
    public void  surfaceDestroyed(SurfaceHolder surfaceHolder){
        paint=null;
    }

    public void draw(){
        surfaceHolder=getHolder();

        Canvas canvas=surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();

        surfaceBackground.setColor(Color.BLACK);

        canvas.drawRect(0,0,this.getWidth(), this.getHeight(), surfaceBackground);

        paint.setColor(Color.RED);
        canvas.drawLine(0,this.getHeight()-b, this.getWidth(), (-(this.getWidth()*m+b))+this.getWidth(), paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public void setM(float m){
        this.m= m;

    }
    public void setB(float b){
        this.b=b*10;

    }
}
