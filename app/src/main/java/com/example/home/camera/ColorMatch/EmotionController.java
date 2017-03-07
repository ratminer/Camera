package com.example.home.camera.ColorMatch;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.camera.R;
import com.example.home.camera.colorHelper.ColorHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertfernandes on 3/3/2017.
 */

public class EmotionController extends ColorViewController {

    private SpeechManager speechManager;
    private Camera camera;

    private String emotion = "";
    private ColorSelections colorSelections;
    private NumberPicker numberPicker;

    private String[] emotions = {
            "1", "2", "3", "4", "5"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(ColorPager.Emotion.getLayoutResId(), container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        numberPicker = (NumberPicker)getView().findViewById(R.id.emotion);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(emotions.length - 1);
        numberPicker.setDisplayedValues(emotions);

        colorSelections = new ColorSelections(getView().findViewById(R.id.colorSelections));
        emotion = emotions[numberPicker.getValue()];
    }

    public EmotionController initialize(SpeechManager speechManager, Camera camera) {
        this.speechManager = speechManager;
        this.camera = camera;
        return this;
    }

    public void addComparingColor(int color) {
        colorSelections.addColor(color);
    }

    @Override
    public void onVolumeUp() {
        speechManager.speak(emotion);
    }

    @Override
    public void onVolumeDown() {
        int color = camera.getColor();
        addComparingColor(color);
        speechManager.speak(ColorHelper.getColorName(ColorHelper.getClosestColor(color)));
    }

    @Override
    public void onTouchScreen() {

    }

    @Override
    public void onSwipeUp() {
        numberPicker.setValue(numberPicker.getValue() + 1);
        emotion = emotions[numberPicker.getValue()];
        speechManager.speak(emotion);
    }

    @Override
    public void onSwipeDown() {
        numberPicker.setValue(numberPicker.getValue() - 1);
        emotion = emotions[numberPicker.getValue()];
        speechManager.speak(emotion);
    }

    @Override
    public void onSwipeLeft() {

    }

    @Override
    public void onSwipeRight() {

    }
}