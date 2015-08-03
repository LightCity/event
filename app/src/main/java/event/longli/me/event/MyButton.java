package event.longli.me.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyButton extends Button {
    private static final String TAG = MyButton.class.getSimpleName();

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private float eventOldX;
    private float eventOldY;

//    private void moveViewByLayout(View view, int rawX, int rawY) {
//        int left = rawX - view.getWidth() / 2;
//        int top = rawY  - view.getHeight() / 2;
//        int right = left + view.getWidth();
//        int bottom = top + view.getHeight();
//
//        view.layout(left, top, right, bottom);
//
//        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        int new_height = layoutParams.height;
//        int new_width = layoutParams.width;
//        Log.d(TAG, "new_height=" + new_height + ", new_width=" + new_width);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Log.w(TAG + " - " + getId(), "onTouchEvent");

        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.w(TAG + " - " + getId(), "onTouchEvent ACTION_DOWN");
                eventOldX = event.getRawX();
                eventOldY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.w(TAG + " - " + getId(), "onTouchEvent ACTION_MOVE");
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
                Log.w(TAG + " - " + getId(), "onTouchEvent ACTION_UP");
                break;
            default:
                break;
        }
        boolean value = super.onTouchEvent(event);
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //Log.w(TAG + " - " + getId(), "dispatchTouchEvent");

        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.w(TAG + " - " + getId(), "dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.w(TAG + " - " + getId(), "dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.w(TAG + " - " + getId(), "dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        boolean value = super.dispatchTouchEvent(event);
        return value;
    }
}
