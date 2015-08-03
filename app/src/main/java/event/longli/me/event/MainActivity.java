package event.longli.me.event;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;


public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyButton myButton = (MyButton) findViewById(R.id.btn_test);
        myButton.setOnTouchListener(new View.OnTouchListener() {
            private String TAG = "btn_test.OnTouchListener";
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.w(TAG, "btn_test.onTouch");
                boolean value = false;
                return value;
            }
        });
        MyLinearLayout ll_outer = (MyLinearLayout) findViewById(R.id.ll_outer);
        ll_outer.setOnTouchListener(new View.OnTouchListener() {
            private String TAG = "ll_outer.OnTouchListener";
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.w(TAG, "onTouch");
                return false;
            }
        });
        MyLinearLayout ll_inner = (MyLinearLayout) findViewById(R.id.ll_inner);
        ll_inner.setOnTouchListener(new View.OnTouchListener() {
            private String TAG = "ll_inner.OnTouchListener";
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.w(TAG, "onTouch");
                return false;
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        return id == R.id.action_settings || super.onOptionsItemSelected(item);
//    }

    //======================================================
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return super.dispatchGenericMotionEvent(ev);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        return super.dispatchTrackballEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent");
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.i(TAG, "dispatchTouchEvent");
        }
        boolean value = super.dispatchTouchEvent(ev);
        return value;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i(TAG, "dispatchKeyEvent");
        return super.dispatchKeyEvent(event);
    }

    //======================================================

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Log.i(TAG, "onTouchEvent");
        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_CANCEL:
                Log.w(TAG, "onTouchEvent - ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.w(TAG, "onTouchEvent - ACTION_DOWN");
                break;
            case MotionEvent.ACTION_HOVER_ENTER:
                Log.w(TAG, "onTouchEvent - ACTION_HOVER_ENTER");
                break;
            case MotionEvent.ACTION_HOVER_EXIT:
                Log.w(TAG, "onTouchEvent - ACTION_HOVER_EXIT");
                break;
            case MotionEvent.ACTION_HOVER_MOVE:
                Log.w(TAG, "onTouchEvent - ACTION_HOVER_MOVE");
                break;
            case MotionEvent.ACTION_MASK:
                Log.w(TAG, "onTouchEvent - ACTION_MASK");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.w(TAG, "onTouchEvent - ACTION_MOVE");
                break;
            case MotionEvent.ACTION_OUTSIDE:
                Log.w(TAG, "onTouchEvent - ACTION_OUTSIDE");
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.w(TAG, "onTouchEvent - ACTION_POINTER_DOWN");
                break;
            case MotionEvent.ACTION_POINTER_INDEX_MASK:
                Log.w(TAG, "onTouchEvent - ACTION_POINTER_INDEX_MASK");
                break;
            case MotionEvent.ACTION_POINTER_INDEX_SHIFT:
                Log.w(TAG, "onTouchEvent - ACTION_POINTER_INDEX_SHIFT");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.w(TAG, "onTouchEvent - ACTION_POINTER_UP");
                break;
            case MotionEvent.ACTION_UP:
                Log.w(TAG, "onTouchEvent - ACTION_UP");
                break;
            default:
                break;
        }
        boolean value = super.onTouchEvent(event);
        return false;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return super.onGenericMotionEvent(event);
    }

    @Override
    public void takeKeyEvents(boolean get) {
        Log.i(TAG, "takeKeyEvents");
        super.takeKeyEvents(get);
    }
}
