package com.android.realize.custom.assembly.seekBar.realize;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.custom.assembly.seekBar.view.CustomLoadingView1;
import com.android.realize.unicom.UiLog;

public class CustomLoadingRealize1 extends AppCompatActivity {
    private static final String TAG = "CustomLoadingRealize1";
    private CustomLoadingView1 mCustomLoadingView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.d(TAG, "onCreate");
        setContentView(R.layout.activity_custom_loadingview1);
        mCustomLoadingView1 = findViewById(R.id.action_customview_customloadingview1);
        mCustomLoadingView1.setProgress(10);
    }
}
