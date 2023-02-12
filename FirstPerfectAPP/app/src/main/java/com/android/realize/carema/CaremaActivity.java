package com.android.realize.carema;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.interfacces.IGeneralInterface;
import com.android.realize.unicom.UiLog;

public class CaremaActivity extends AppCompatActivity implements IGeneralInterface {
    private final static String TAG = "CaremaActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.d(TAG, "onCreate:");
        setContentView(R.layout.activity_carema);
    }

    @Override
    protected void onStart() {
        super.onStart();
        UiLog.d(TAG, "onStart:");
    }

    @Override
    public void init() {
        UiLog.d(TAG, "init:");
    }

    @Override
    public void release() {
        UiLog.d(TAG, "release:");
    }

    @Override
    protected void onResume() {
        super.onResume();
        UiLog.d(TAG, "onResume:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        UiLog.d(TAG, "onPause:");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStop() {
        super.onStop();
        UiLog.d(TAG, "onStop:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UiLog.d(TAG, "onDestroy:");
    }
}
