package event.longli.me.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;


public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private int observerWidth = 0;
    private int observerHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent - " + EventUtil.eventName(ev));
        boolean value = super.dispatchTouchEvent(ev);
        return value;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent - " + EventUtil.eventName(event));
        boolean value = super.onTouchEvent(event);
        return value;
    }
}
