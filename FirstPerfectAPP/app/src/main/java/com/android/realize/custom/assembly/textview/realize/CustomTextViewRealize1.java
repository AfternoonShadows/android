package com.android.realize.custom.assembly.textview.realize;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.custom.assembly.textview.view.CustomTextView1;
import com.android.realize.unicom.UiLog;

public class CustomTextViewRealize1 extends AppCompatActivity {

    private static final String TAG = "customTextViewrealize1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.d(TAG, "onCreate");
        setContentView(R.layout.activity_custom_textview1);
        CustomTextView1 customTextView1 = findViewById(R.id.action_customview_customtextview1);
    }
}
