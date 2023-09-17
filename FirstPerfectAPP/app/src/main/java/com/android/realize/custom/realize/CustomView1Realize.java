package com.android.realize.custom.realize;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.custom.view.CustomView1;
import com.android.realize.custom.view.CustomView2;
import com.android.realize.unicom.UiLog;

public class CustomView1Realize extends AppCompatActivity {
    private static final String TAG = "customView1Realize";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UiLog.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activoty_custom_customview1);
        CustomView1 customView1 = findViewById(R.id.action_customview_CustomView1);
        CustomView2 customView2 = findViewById(R.id.action_customview_CustomView2);
    }
}
