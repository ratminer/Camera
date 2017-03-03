package com.example.home.camera.ColorMatch;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertfernandes on 3/3/2017.
 */

public abstract class ColorViewController extends Fragment {

    protected List<ColorView> colorViewList = new ArrayList<>();

    public void addView(ColorView colorView) {
        colorViewList.add(colorView);
    }

    public void drawViews() {
        for (ColorView cv : colorViewList) {
            if (cv != null) {
                cv.draw();
            }
        }
    }

    public abstract void onVolumeUp();

    public abstract void onVolumeDown();

    public abstract void onTouchScreen();

    public abstract void onSwipeUp();

    public abstract void onSwipeDown();

    public abstract void onSwipeLeft();

    public abstract void onSwipeRight();
}
