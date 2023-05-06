package com.android.realize.activity.scrollview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.interfacces.IGeneralInterface;
import com.android.realize.unicom.UiLog;

public class ScrollViewActivity extends AppCompatActivity implements IGeneralInterface {
    private static final String TAG = "ScrollViewActivity";
    private OnClick mOnClick;
    private ScrollView mScrollView;
    private Button mScrollViewUp;
    private Button mScrollViewDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void init() {
        mOnClick = new OnClick();

        mScrollViewUp = findViewById(R.id.activity_scrollview_btn_up);
        mScrollViewDown = findViewById(R.id.activity_scrollview_btn_down);
        mScrollView = findViewById(R.id.activity_scrollview_sv);
        mScrollViewUp.setOnClickListener(mOnClick);
        mScrollViewDown.setOnClickListener(mOnClick);
    }

    @Override
    public void release() {

    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                // 移动到滚动框顶端
                case R.id.activity_scrollview_btn_up: {
                    mScrollView.fullScroll(View.FOCUS_UP);
                    break;
                }
                // 移动到滚动框末端
                case R.id.activity_scrollview_btn_down: {
                    mScrollView.fullScroll(View.FOCUS_DOWN);
                    break;
                }
                default: {
                    UiLog.w(TAG, "event error");
                    break;
                }
            }
        }
    }
}
