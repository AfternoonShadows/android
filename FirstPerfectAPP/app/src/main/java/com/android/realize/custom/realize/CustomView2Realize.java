package com.android.realize.custom.realize;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.custom.view.CustomView2;
import com.android.realize.unicom.UiLog;

public class CustomView2Realize extends AppCompatActivity {
    private static final String TAG = "CustomView2Realize";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.d(TAG, "onCreate");
        setContentView(R.layout.activity_custom_customview2);
        CustomView2 customView2 = findViewById(R.id.action_customview_CustomView2);
    }
}
