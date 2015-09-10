package event.longli.me.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {
    private static final String TAG = MyLinearLayout.class.getSimpleName();

//    private float eventOldX;
//    private float eventOldY;

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, getStrId() + " - OnClickListener.onClick");
            }
        });
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, getStrId() + " - OnTouchListener.onTouch");
                boolean value = true;
                return value;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, getStrId() + " - dispatchTouchEvent " + EventUtil.eventName(ev));
        boolean value = super.dispatchTouchEvent(ev);
        return value;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG  , getStrId() + " - onInterceptTouchEvent " + EventUtil.eventName(ev));
        boolean value = super.onInterceptTouchEvent(ev);
        return value;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, getStrId() +  " - onTouchEvent " + EventUtil.eventName(event));
        boolean value = super.onTouchEvent(event);
        return value;
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.e(TAG, getStrId() + " - requestDisallowInterceptTouchEvent");
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    private String getStrId() {
        int id = getId();

        switch (id) {
            case R.id.ll_outer:
                return "ll_outer";
            case R.id.ll_inner:
                return "ll_inner";
            case R.id.ll_black:
                return "ll_black";
            default:
                return EventUtil.getNameOfId(id);
        }
    }
}


//        final float newRawX = event.getRawX();
//        final float newRawY = event.getRawY();
//
//        int action = event.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG,  getStrId() + " - onTouchEvent ACTION_MOVE");
//                float xInterval = newRawX - eventOldX;
//                float yInterval = newRawY - eventOldY;
//                int oldLeft = getLeft();
//                int oldTop = getTop();
//                int oldRight = getRight();
//                int oldBottom = getBottom();
//                int left    = (int) ( oldLeft + xInterval );
//                int top     = (int) ( oldTop + yInterval );
//                int right   = left + getWidth();
//                int bottom  = top + getHeight();
//                this.layout(left, top, right, bottom);
//                break;
//            default:
//                break;
//        }
//        eventOldX = newRawX;
//        eventOldY = newRawY;
