package com.example.polyfilms;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class onSwipeClickListener implements View.OnTouchListener
{
    private float initX;
    private float initY;
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    public onSwipeClickListener()
    {
        // super();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        boolean result = false;

        //Log.d("ON SWIPE CLICK LISTENER","on TOUCH détecté");
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                Log.d("ON SWIPE CLICK LISTENER","DOWN (pressed) : initX = "+initX+" initY = "+initY);
                initX = event.getX();
                initY = event.getY();
                result= true;
                break;


            case MotionEvent.ACTION_UP:

                initX -= event.getX(); //now has difference value
                initY -= event.getY(); //now has difference value
                Log.d("ON SWIPE CLICK LISTENER","UP (released) : initX = "+initX+" initY = "+initY);

                if(Math.abs(initX) < SWIPE_THRESHOLD && Math.abs(initY) < SWIPE_THRESHOLD) {
                    v.performClick();
                }
                else if(Math.abs(initX)>Math.abs(initY)){

                    if(Math.abs(initX)>SWIPE_THRESHOLD)
                    {

                        if(initX>0) onSwipeLeft();
                        else onSwipeRight();
                    }
                }
                else{
                    if(Math.abs(initY)>SWIPE_THRESHOLD)
                    {
                        if(initY>0) onSwipeTop();
                        else onSwipeBottom();
                    }
                }

                break;
        }
        return result;
    }

    public void onSwipeTop(){Log.d("ON SWIPE CLICK LISTENER","SwipeTop event");}
    public void onSwipeBottom(){Log.d("ON SWIPE CLICK LISTENER","SwipeBottom event");}
    public void onSwipeLeft(){Log.d("ON SWIPE CLICK LISTENER","SwipeLeft event");}
    public void onSwipeRight(){Log.d("ON SWIPE CLICK LISTENER","SwipeRight event");}
}