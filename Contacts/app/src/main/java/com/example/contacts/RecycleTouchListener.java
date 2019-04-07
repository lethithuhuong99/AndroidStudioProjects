package com.example.contacts;

import android.content.Context;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class RecycleTouchListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListner mListener;
    GestureDetector mGestureDetector;

    public interface OnItemClickListner {
        public void onItemClick (View view, int position);
        public void onLongItemClick(View view, int position);
    }
    public RecycleTouchListener(Context context, final RecyclerView recyclerView, OnItemClickListner listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp (MotionEvent e) {return true;}

            @Override
            public void onLongPress(MotionEvent e){
               View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
               if (child != null && mListener != null) {
                   mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
               }
           }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(),e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
