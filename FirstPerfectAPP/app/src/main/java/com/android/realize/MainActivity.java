package com.android.realize;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.realize.unicom.UiLog;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private Fragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        UiLog.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
    }

    @Override
    protected void onStart() {
        UiLog.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        UiLog.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        UiLog.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        UiLog.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        UiLog.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    /**
     * toggleFragment 动态切换fragment(不保存数据).
     *
     * @param fragment
     */
    private void toggleFragment(Fragment fragment) {
        UiLog.d(TAG, "toggleFragment: " + fragment.getClass().getSimpleName());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

    /**
     * switchFragment 动态切换保存数据。
     *
     * @param fragment
     */
    private void switchFragment(Fragment fragment) {
        UiLog.d(TAG, "switchFragment: " + fragment.getClass().getSimpleName());
        // 已经显示，不在切替
        if (mFragment == fragment) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            /**
             * fragmentTransaction.hide(mFragment).add(R.id.content, fragment).commit();.
             */
            fragmentTransaction.hide(mFragment);
            fragmentTransaction.add(R.id.content, fragment);
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
