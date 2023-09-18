package com.android.realize.custom.realize;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.custom.view.CustomView1;
import com.android.realize.unicom.UiLog;

public class CustomView1Realize extends AppCompatActivity {
    private static final String TAG = "CustomView1Realize";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.d(TAG, "onCreate");
        setContentView(R.layout.activity_custom_customview1);
        CustomView1 customView1 = findViewById(R.id.action_customview_CustomView1);
    }
}
