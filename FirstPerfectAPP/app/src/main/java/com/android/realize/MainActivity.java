package com.android.realize;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.realize.fragment.FragmentModuleRealize;
import com.android.realize.fragment.FragmentVideoRealize;
import com.android.realize.fragment.FragmentVoiceRealize;
import com.android.realize.unicom.UiLog;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private Fragment mFragment = null;
    private Button mBtnModel;
    private Button mBtnVoice;
    private Button mBtnVideo;
    private OnClick mOnClick;
    private FragmentModuleRealize mFragmentModuleRealize;
    private FragmentVoiceRealize mFragmentVoiceRealize;
    private FragmentVideoRealize mFragmentVideoRealize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.i(TAG, "onCreate: ");
        setContentView(R.layout.activity);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        UiLog.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        UiLog.i(TAG, "onResume: ");
    }

    /**
     * 在AndroidManifest.xml中加入
     * android:configChanges="orientation|keyboardHidden|screenSize|screenLayout"
     * 加入该配置后，不管是进入多窗口还是横屏切换，活动都不会被创新创建
     * 而是将屏幕变化通知到Activity的onConfigurationChanged()中
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPause() {
        super.onPause();
        UiLog.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        UiLog.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UiLog.i(TAG, "onDestroy: ");
        realease();
    }

    /**
     * init data.
     */
    public void init() {
        UiLog.d(TAG, "init: ");
        // 初始化对象.
        mOnClick = new OnClick();
        mFragmentModuleRealize = new FragmentModuleRealize();
        mFragmentVoiceRealize = new FragmentVoiceRealize();
        mFragmentVideoRealize = new FragmentVideoRealize();
        // 初始化组件.
        mBtnModel = findViewById(R.id.activity_btn_module);
        mBtnVoice = findViewById(R.id.activity_btn_voice);
        mBtnVideo = findViewById(R.id.activity_btn_video);
        // 设置监听.
        mBtnModel.setOnClickListener(mOnClick);
        mBtnVoice.setOnClickListener(mOnClick);
        mBtnVideo.setOnClickListener(mOnClick);
    }

    /**
     * realease data.
     */
    public void realease() {
        UiLog.d(TAG, "realease: ");
        mOnClick = null;
        mFragmentModuleRealize = null;
        mFragmentVoiceRealize = null;
        mFragmentVideoRealize = null;
        mBtnModel = null;
        mBtnVoice = null;
        mBtnVideo = null;
    }

    /**
     * toggleFragment 动态切换fragment(不保存数据).
     *
     * @param fragment
     */
    private void toggleFragment(Fragment fragment) {
        UiLog.d(TAG, "toggleFragment: name = " + fragment.getClass().getSimpleName());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_fl_content, fragment);
        // 该方法使程序点击back时，不直接结束程序，而是返回到上一个fragment(将事物添加到返回栈中)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * switchFragment 动态切换保存数据.
     *
     * @param fragment
     */
    private void switchFragment(Fragment fragment) {
        UiLog.d(TAG, "switchFragment: name = " + fragment.getClass().getSimpleName());
        // 已经显示，不在切替.
        if (mFragment == fragment) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 判断需要显示的fragment是否已经显示过,如果mFragment为null直接添加Fragment画面.
        if (mFragment == null) {
            fragmentTransaction.add(R.id.activity_fl_content, fragment);
            fragmentTransaction.commit();
        } else if (!fragment.isAdded()) {
            /**
             * fragmentTransaction.hide(mFragment).add(R.id.content, fragment).commit();.
             */
            fragmentTransaction.hide(mFragment);
            fragmentTransaction.add(R.id.activity_fl_content, fragment);
            fragmentTransaction.commit();
        } else {
            // 都添加了，则隐藏当前fragment,展示需要显示的fragment.
            fragmentTransaction.hide(mFragment);
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }
        mFragment = fragment;
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            UiLog.d(TAG, "OnClick: " + v.getId());
            switch (v.getId()) {
                case R.id.activity_btn_module: {
                    switchFragment(mFragmentModuleRealize);
                    break;
                }
                case R.id.activity_btn_voice: {
                    switchFragment(mFragmentVoiceRealize);
                    break;
                }
                case R.id.activity_btn_video: {
                    switchFragment(mFragmentVideoRealize);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
