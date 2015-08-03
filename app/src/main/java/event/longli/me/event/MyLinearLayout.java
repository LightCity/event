package event.longli.me.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {
    private static final String TAG = MyLinearLayout.class.getSimpleName();

    private float eventOldX;
    private float eventOldY;

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //Log.e(TAG + " - " + getStrId(), "dispatchTouchEvent");
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG + " - " +  getStrId(), "dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG + " - " +  getStrId(), "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG + " - " +  getStrId(), "dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        boolean value = super.dispatchTouchEvent(ev);
        return value;
    }
    
    private String getStrId() {
        int id = getId();
        return id == R.id.ll_outer
                ?
                "ll_outer"
                :
                (id == R.id.ll_inner ? "ll_inner" : "" + id );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Log.e(TAG + " - " +  getStrId(), "onTouchEvent");
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG + " - " +  getStrId(), "onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG + " - " +  getStrId(), "onTouchEvent ACTION_MOVE");
                final float newRawX = event.getRawX();
                final float newRawY = event.getRawY();

                float xInterval = newRawX - eventOldX;
                float yInterval = newRawY - eventOldY;

                int left    = (int) ( getLeft() + xInterval );
                int top     = (int) ( getTop() + yInterval );
                int right   = left + getWidth();
                int bottom  = top + getHeight();

                int oldLeft = getLeft();
                int oldTop = getTop();
                int oldRight = getRight();
                int oldBottom = getBottom();

                this.layout(left, top, right, bottom);

                eventOldX = newRawX;
                eventOldY = newRawY;
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG + " - " +  getStrId(), "onTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        boolean value = super.onTouchEvent(event);
        return value;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //Log.e(TAG + " - " +  getStrId(), "onInterceptTouchEvent");
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG + " - " +  getStrId(), "onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG + " - " +  getStrId(), "onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG + " - " +  getStrId(), "onInterceptTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        boolean value = super.onInterceptTouchEvent(ev);
        return value;
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.e(TAG + " - " +  getStrId(), "requestDisallowInterceptTouchEvent");
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }
}
