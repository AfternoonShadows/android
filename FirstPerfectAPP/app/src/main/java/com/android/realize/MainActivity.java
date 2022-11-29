package com.android.realize;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.unicom.UiLog;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        UiLog.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        UiLog.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        UiLog.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        UiLog.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        UiLog.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        UiLog.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
