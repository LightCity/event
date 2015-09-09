package event.longli.me.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MyButton extends Button {
    private static final String TAG = MyButton.class.getSimpleName();



    public MyButton(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, EventUtil.getNameOfId(getId()) + " - " + "OnClickListener.onClick");
                Toast.makeText(context, "width=" + getWidth() + ", height=" + getHeight(), Toast.LENGTH_SHORT).show();
            }
        });
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, EventUtil.getNameOfId(getId()) + " - OnTouchListener.onTouch");
                return false;
            }
        });
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
    public boolean dispatchTouchEvent(MotionEvent event) {
        //Log.e(TAG + " - " + getId(), "dispatchTouchEvent");

        int action = event.getAction();
        String idName = EventUtil.getNameOfId(getId());

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, idName + " - dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, idName + " - dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, idName + " - dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        boolean value = super.dispatchTouchEvent(event);
        return value;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Log.e(TAG + " - " + getId(), "onTouchEvent");
        final float newRawX = event.getRawX();
        final float newRawY = event.getRawY();

        int action = event.getAction();
        String idName = EventUtil.getNameOfId(getId());

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, idName + " - onTouchEvent ACTION_DOWN");
                eventOldX = event.getRawX();
                eventOldY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, idName + " - onTouchEvent ACTION_MOVE");

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

                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, idName + " - onTouchEvent ACTION_UP");
                break;
            default:
                break;
        }

        eventOldX = newRawX;
        eventOldY = newRawY;

        boolean value = super.onTouchEvent(event);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String str = element.toString();
            if (str.indexOf("longli") > 0)
                Log.e(TAG, "======== " + element.toString());
        }
        return value; // 必须要返回true，否则ACTION_DOWN的后续事件不会到达
    }
}
