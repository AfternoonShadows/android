package com.android.realize.custom.realize;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.custom.view.CustomView4;
import com.android.realize.unicom.UiLog;

public class CustomView4Realize extends AppCompatActivity {
    private static final String TAG = "CustomView4Realize";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.d(TAG, "onCreate");
        setContentView(R.layout.activity_custom_customview4);
        CustomView4 customView4 = findViewById(R.id.action_customview_CustomView4);
    }
}