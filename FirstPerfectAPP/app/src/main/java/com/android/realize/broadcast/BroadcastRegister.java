package com.android.realize.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.realize.unicom.UiLog;

public class BroadcastRegister extends BroadcastReceiver {
    private static final String TAG = BroadcastRegister.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        UiLog.i(TAG, "动态注册广播");
        Toast.makeText(context, "动态注册广播", Toast.LENGTH_SHORT).show();
    }
}
