package event.longli.me.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;


public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private int observerWidth = 0;
    private int observerHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final MyButton btn = (MyButton) findViewById(R.id.btn_test);

        btn.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                observerWidth = btn.getWidth();
                observerHeight = btn.getHeight();
                Log.e(TAG, "observerWidth=" + observerWidth + ", observerHeight=" + observerHeight);
            }
        });

        int measuredHeight = btn.getMeasuredHeight();
        int measuredWidth = btn.getMeasuredWidth();
        int measuredHeightAndState = btn.getMeasuredHeightAndState();
        int measuredWidthAndState = btn.getMeasuredWidthAndState();
        btn.measure(View.MeasureSpec.EXACTLY, View.MeasureSpec.EXACTLY);
        int measuredHeight_2 = btn.getMeasuredHeight();
        int measuredWidth_2 = btn.getMeasuredWidth();
        int measuredHeightAndState_2 = btn.getMeasuredHeightAndState();
        int measuredWidthAndState_2 = btn.getMeasuredWidthAndState();

        Log.e(TAG, "before measure: measuredHeight=" + measuredHeight + ", measuredWidth=" + measuredWidth + ", measuredHeightAndState=" + measuredHeightAndState + ", measuredWidthAndState" + measuredWidthAndState);
        Log.e(TAG, "after  measure: measuredHeight=" + measuredHeight_2 + ", measuredWidth=" + measuredWidth_2 + ", measuredHeightAndState=" + measuredHeightAndState_2 + ", measuredWidthAndState" + measuredWidthAndState_2);

//        MyButton myButton = (MyButton) findViewById(R.id.btn_test);
//        myButton.setOnTouchListener(new View.OnTouchListener() {
//            private String TAG = "btn_test.OnTouchListener";
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG, "btn_test.onTouch");
//                boolean value = false;
//                return value;
//            }
//        });
//        MyLinearLayout ll_outer = (MyLinearLayout) findViewById(R.id.ll_outer);
//        ll_outer.setOnTouchListener(new View.OnTouchListener() {
//            private String TAG = "ll_outer.OnTouchListener";
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG, "onTouch");
//                return false;
//            }
//        });
//        MyLinearLayout ll_inner = (MyLinearLayout) findViewById(R.id.ll_inner);
//        ll_inner.setOnTouchListener(new View.OnTouchListener() {
//            private String TAG = "ll_inner.OnTouchListener";
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG, "onTouch");
//                return false;
//            }
//        });
    }

//    //======================================================
//    @Override
//    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
//        return super.dispatchPopulateAccessibilityEvent(event);
//    }
//
//    @Override
//    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
//        return super.dispatchGenericMotionEvent(ev);
//    }
//
//    @Override
//    public boolean dispatchTrackballEvent(MotionEvent ev) {
//        return super.dispatchTrackballEvent(ev);
//    }
//
//    @Override
//    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
//        return super.dispatchKeyShortcutEvent(event);
//    }
//
//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        Log.e(TAG, "dispatchKeyEvent");
//        return super.dispatchKeyEvent(event);
//    }
////
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent - " + EventUtil.eventName(ev));
        boolean value = super.dispatchTouchEvent(ev);
        return value;
    }

//    //======================================================

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onTouchEvent - ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent - ACTION_DOWN");
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                Log.e(TAG, "onTouchEvent - ACTION_HOVER_ENTER");
                break;
            case MotionEvent.ACTION_HOVER_EXIT:
                Log.e(TAG, "onTouchEvent - ACTION_HOVER_EXIT");
                break;
            case MotionEvent.ACTION_HOVER_MOVE:
                Log.e(TAG, "onTouchEvent - ACTION_HOVER_MOVE");
                break;
            case MotionEvent.ACTION_MASK:
                Log.e(TAG, "onTouchEvent - ACTION_MASK");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent - ACTION_MOVE");
                break;
            case MotionEvent.ACTION_OUTSIDE:
                Log.e(TAG, "onTouchEvent - ACTION_OUTSIDE");
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.e(TAG, "onTouchEvent - ACTION_POINTER_DOWN");
                break;
            case MotionEvent.ACTION_POINTER_INDEX_MASK:
                Log.e(TAG, "onTouchEvent - ACTION_POINTER_INDEX_MASK");
                break;
            case MotionEvent.ACTION_POINTER_INDEX_SHIFT:
                Log.e(TAG, "onTouchEvent - ACTION_POINTER_INDEX_SHIFT");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.e(TAG, "onTouchEvent - ACTION_POINTER_UP");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent - ACTION_UP");
                break;
            default:
                break;
        }
        boolean value = super.onTouchEvent(event);
        return false;
    }


//
//    @Override
//    public boolean onTrackballEvent(MotionEvent event) {
//        return super.onTrackballEvent(event);
//    }
//
//    @Override
//    public boolean onGenericMotionEvent(MotionEvent event) {
//        return super.onGenericMotionEvent(event);
//    }
//
//    @Override
//    public void takeKeyEvents(boolean get) {
//        Log.e(TAG, "takeKeyEvents");
//        super.takeKeyEvents(get);
//    }
}
