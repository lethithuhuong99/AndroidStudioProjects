package com.example.boucingball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyView extends View implements Runnable {
    private int x1 = 100, y1 = 100, dx1 = 10, dy1 = 10, radius = 100, yBar = 1500, xBar = 0, widthSlideBar = 400,heightSlideBar= 100;
    private int x2 = 200, y2 = 200, dx2 = 20, dy2 = 20;
    Bitmap ballResize,ballResize2;
    Bitmap bgBitmap;
    Bitmap slideBarResize;
    ArrayList<Brick> lists;

    public MyView (Context  context, AttributeSet attrs) {
        super(context,attrs);
        bgBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        Bitmap ball = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        ballResize = Bitmap.createScaledBitmap(ball,radius,radius,false);
        Bitmap ball2 = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        ballResize2 = Bitmap.createScaledBitmap(ball2,radius,radius,false);
        Bitmap slideBar = BitmapFactory.decodeResource(getResources(),R.drawable.slidebar);
        slideBarResize = Bitmap.createScaledBitmap(slideBar,widthSlideBar,heightSlideBar,false);
        lists = new ArrayList<Brick>();
        for(int i = 0 ; i < 7 ; i++){
            Brick brick = new Brick(210*i , 0, 200  ,100);
            lists.add(brick);
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x= this.getWidth();
        int y = this.getHeight();
        canvas.drawBitmap(bgBitmap, 0, 0, null);
        canvas.drawBitmap(ballResize,x1,y1,null);
        canvas.drawBitmap(ballResize2,x2,y2,null);
        canvas.drawBitmap(slideBarResize, xBar,yBar, null);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        for(Brick element : lists){
            element.drawBrick(canvas , paint);
            if(element.getVisibility()){
                if (Math.sqrt(Math.pow(x1-element.getX(),2)+ Math.pow(y1-element.getY(),2))<50) {
                    element.setVisible(false);
                    dy1 = -dy1;

                }
            }
        }

        if (x1 + radius > x || x1 < 0)
        {
            dx1 = -dx1;
        }

        if (y1 + radius > y || y1 < 0)
        {
            dy1 = -dy1;
        }

        if (x2 + radius > x || x2 < 0)
        {
            dx2 = -dx2;
        }

        if (y2 + radius > y || y2 < 0)
        {
            dy2 = -dy2;
        }

        Log.d("bar", "BAR: " + "xBar = " + xBar +" yBar = " + yBar);

        if (Math.sqrt(Math.pow(x1-x2,2)+ Math.pow(y1-y2,2))<radius) {
            dy1 = -dy1;
            dx1 = -dx1;
            dy2 = -dy2;
            dx2 = -dx2;
        }

        if ( (x1 <= xBar + widthSlideBar) && (x1+radius >= xBar) && (yBar == y1+radius)) {
            dy1 = -dy1;
        }

        update();
        invalidate();


    }

    private void update() {
        x1 += dx1;
        y1 += dy1;
        x2 += dx2;
        y2 += dy2;
    }

    @Override
    public void run() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        boolean handled = false;
        int xTouch, yTouch;
        int actionIndex = event.getActionIndex();

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                xTouch = (int) event.getX(0);
                yTouch = (int) event.getY(0);

                xBar = xTouch;
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                xTouch = (int) event.getX(actionIndex);
                yTouch = (int) event.getY(actionIndex);

                handled = true;
                break;

            case MotionEvent.ACTION_MOVE:
                final int pointerCount = event.getPointerCount();

                for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {
                    xTouch = (int) event.getX(actionIndex);
                    yTouch = (int) event.getY(actionIndex);
                    xBar=xTouch;
                    if (xBar + widthSlideBar >= this.getWidth()) {
                        xBar = this.getWidth() - widthSlideBar;
                    }
                }

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_UP:
                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_UP:
                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_CANCEL:
                handled = true;
                break;

                default:
                    break;
        }
        return  super.onTouchEvent(event) || handled;
    }
}
