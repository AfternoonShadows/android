package com.android.realize.custom.realize;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.custom.view.CustomView3;
import com.android.realize.unicom.UiLog;

public class CustomView3Realize extends AppCompatActivity {
    private static final String TAG = "CustomView3Realize";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.d(TAG,"onCreate");
        setContentView(R.layout.activity_custom_customview3);
        CustomView3 customView3 = findViewById(R.id.action_customview_CustomView3);
    }
}
