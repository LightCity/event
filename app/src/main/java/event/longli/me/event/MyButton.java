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
                boolean value = false;
                return value;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        String idName = EventUtil.getNameOfId(getId());
        Log.e(TAG, idName + " - dispatchTouchEvent " + EventUtil.eventName(event));
        boolean value = super.dispatchTouchEvent(event);
        return value;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String idName = EventUtil.getNameOfId(getId());
        Log.e(TAG, idName + " - onTouchEvent " + EventUtil.eventName(event));
        EventUtil.logStackTrace(TAG, event);
        boolean value = super.onTouchEvent(event);
        return value; // 必须要返回true，否则ACTION_DOWN的后续事件不会到达
    }
}





//private float eventOldX;
//private float eventOldY;

//        final float newRawX = event.getRawX();
//        final float newRawY = event.getRawY();
//
//        int action = event.getAction();
//
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                eventOldX = event.getRawX();
//                eventOldY = event.getRawY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//
//                float xInterval = newRawX - eventOldX;
//                float yInterval = newRawY - eventOldY;
//
//                int left    = (int) ( getLeft() + xInterval );
//                int top     = (int) ( getTop() + yInterval );
//                int right   = left + getWidth();
//                int bottom  = top + getHeight();
//
//                int oldLeft = getLeft();
//                int oldTop = getTop();
//                int oldRight = getRight();
//                int oldBottom = getBottom();
//
//                this.layout(left, top, right, bottom);
//
//                break;
//            default:
//                break;
//        }
//        eventOldX = newRawX;
//        eventOldY = newRawY;




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