package ssu.groupname.baseapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class PView extends View {

    public static final int numberOfKeys = 14;
    private Paint black, blue, white;
    private HashMap<Integer, Keys> whites = new HashMap<>();
    private HashMap<Integer, Keys> blacks = new HashMap<>();
    private int keyWidth, height;
    private AudioSound Sound;

    public PView(Context context, AttributeSet attset) {
        super(context, attset);
        black = new Paint();
        black.setColor(Color.BLACK);
        white = new Paint();
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);
        Sound = new AudioSound(context);

    }

    @Override
    protected void onSizeChanged (int w, int h, int oldwidth, int oldheight) {
        super.onSizeChanged(w, h, oldwidth, oldheight);
        keyWidth = w / numberOfKeys;
        height = h;
        int count = 17;

        for (int i = 0; i < numberOfKeys; i++) {
            int left = i * keyWidth;
            int right = left + keyWidth;

            if ( i == numberOfKeys - 1 ) {
                right = w;
            }

            RectF rect = new RectF(left, 0, right, h);
            whites.put( i + 1, new Keys(rect, i + 1));

            if (i != 0 && i != 3 && i != 7 && i != 10) {
                rect = new RectF((float) (i - 1) * keyWidth + 0.5f * keyWidth + 0.25f * keyWidth, 0, (float) i * keyWidth + 0.25f * keyWidth, 0.67f * height);
                blacks.put(count, new Keys(rect, count));
                count ++;
            }


        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Keys k : whites.values()) {
            canvas.drawRect(k.rect, k.down ? blue : white);
        }
        for (int i = 1; i < numberOfKeys; i++) {
            canvas.drawLine(i * keyWidth, 0, i * keyWidth, height, black);
        }
        for (Keys k : blacks.values()) {
            canvas.drawRect(k.rect, k.down ? blue : black);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        boolean downAction = action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE;
        for (int Index = 0; Index < event.getPointerCount(); Index++) {
            float y = event.getY(Index);
            float x = event.getX(Index);

            Keys k = keycords(x, y);
            if(k != null) {
                k.down = downAction;
            }
        }

        ArrayList<Keys> tmp = new ArrayList<>(whites.values());
        tmp.addAll(blacks.values());
        for(Keys k : tmp) {
            if(k.down) {
                if(!Sound.notePlaying(k.sound)) {
                    Sound.notePlay(k.sound);
                    invalidate();
                }
//                else
                Sound.noteStop(k.sound);
                letGoKey(k);
            }
        }
        return true;
    }

    private Keys keycords(float x, float y) {
        for (Keys k : blacks.values()) {
            if (k.rect.contains(x, y)){
                return k;
            }
        }
        for (Keys k : whites.values()) {
            if (k.rect.contains(x, y)){
                return k;
            }
        }

        return null;
    }

    private void letGoKey(final Keys k) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                k.down = false;
                handler.sendEmptyMessage(0);
            }
        }, 100);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            invalidate();
        }
    };

}
