package event.longli.me.event;

import android.util.Log;
import android.view.MotionEvent;

public class EventUtil {
    public static String eventName(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";
                
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
                
            case MotionEvent.ACTION_HOVER_ENTER:
                return "ACTION_HOVER_ENTER";
                
            case MotionEvent.ACTION_HOVER_EXIT:
                return "ACTION_HOVER_EXIT";
                
            case MotionEvent.ACTION_HOVER_MOVE:
                return "ACTION_HOVER_MOVE";
                
            case MotionEvent.ACTION_MASK:
                return "ACTION_MASK";
                
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
                
            case MotionEvent.ACTION_OUTSIDE:
                return "ACTION_OUTSIDE";
                
            case MotionEvent.ACTION_POINTER_DOWN:
                return "ACTION_POINTER_DOWN";
                
            case MotionEvent.ACTION_POINTER_INDEX_MASK:
                return "ACTION_POINTER_INDEX_MASK";
                
            case MotionEvent.ACTION_POINTER_INDEX_SHIFT:
                return "ACTION_POINTER_INDEX_SHIFT";
                
            case MotionEvent.ACTION_POINTER_UP:
                return "ACTION_POINTER_UP";
                
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
                
            default:
                return "UNKNOW";
                
        }
    }
}
