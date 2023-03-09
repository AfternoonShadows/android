package com.android.realize.activity.scrollview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.interfacces.IGeneralInterface;

public class ScrollViewActivity extends AppCompatActivity implements IGeneralInterface {
    private static final String TAG = "ScrollViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }
}
