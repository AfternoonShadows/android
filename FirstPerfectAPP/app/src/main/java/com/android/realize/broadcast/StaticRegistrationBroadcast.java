package com.android.realize.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.android.realize.unicom.UiLog;

/**
 *
 **/
public class StaticRegistrationBroadcast extends BroadcastReceiver {
    private static final String TAG = StaticRegistrationBroadcast.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        UiLog.i(TAG, "广播静态注册实现");
    }
}
