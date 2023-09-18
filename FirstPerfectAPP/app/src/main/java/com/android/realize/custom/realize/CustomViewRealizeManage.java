package com.android.realize.custom.realize;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.interfacces.IGeneralInterface;
import com.android.realize.unicom.UiLog;

public class CustomViewRealizeManage extends AppCompatActivity implements IGeneralInterface {
    private static final String TAG = "customView1Realize";
    private OnClick mOnClick;
    private Button mCustomView1;
    private Button mCustomView2;
    private Button mCustomView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UiLog.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_customview_manage);
        init();
    }

    @Override
    public void init() {
        mOnClick = new OnClick();
        mCustomView1 = findViewById(R.id.activity_custom_btn_customview1);
        mCustomView2 = findViewById(R.id.activity_custom_btn_customview2);
        mCustomView3 = findViewById(R.id.activity_custom_btn_customview3);

        mCustomView1.setOnClickListener(mOnClick);
        mCustomView2.setOnClickListener(mOnClick);
        mCustomView3.setOnClickListener(mOnClick);
    }

    @Override
    public void release() {
        mOnClick = null;
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.activity_custom_btn_customview1: {
                    Intent intent = new Intent(CustomViewRealizeManage.this, CustomView1Realize.class);
                    startActivity(intent);
                    break;
                }
                case R.id.activity_custom_btn_customview2: {
                    Intent intent = new Intent(CustomViewRealizeManage.this, CustomView2Realize.class);
                    startActivity(intent);
                    break;
                }
                case R.id.activity_custom_btn_customview3: {
                    Intent intent = new Intent(CustomViewRealizeManage.this, CustomView3Realize.class);
                    startActivity(intent);
                    break;
                }
                default:
                    break;
            }
        }
    }
}
