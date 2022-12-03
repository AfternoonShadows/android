package com.android.realize;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.realize.unicom.UiLog;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UiLog.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
    }

    @Override
    protected void onStart() {
        UiLog.i(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        UiLog.i(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        UiLog.i(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        UiLog.i(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        UiLog.i(TAG, "onDestroy: ");
        super.onDestroy();
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
        fragmentTransaction.commit();
    }

    /**
     * switchFragment 动态切换保存数据。
     *
     * @param fragment
     */
    private void switchFragment(Fragment fragment) {
        UiLog.d(TAG, "switchFragment: name = " + fragment.getClass().getSimpleName());
        // 已经显示，不在切替
        if (mFragment == fragment) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 判断需要显示的fragment是否已经显示过
        if (!fragment.isAdded()) {
            /**
             * fragmentTransaction.hide(mFragment).add(R.id.content, fragment).commit();.
             */
            fragmentTransaction.hide(mFragment);
            fragmentTransaction.add(R.id.activity_fl_content, fragment);
            fragmentTransaction.commit();
        } else {
            // 都添加了，则隐藏当前fragment,展示需要显示的fragment
            fragmentTransaction.hide(mFragment);
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }
        mFragment = fragment;
    }
}
