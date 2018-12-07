package ssu.groupname.baseapplication;

import android.graphics.RectF;

public class Keys {
    public int sound;
    public RectF rect;
    public boolean down;

    public Keys(RectF rect, int sound) {
        this.sound = sound;
        this.rect = rect;
    }
}
