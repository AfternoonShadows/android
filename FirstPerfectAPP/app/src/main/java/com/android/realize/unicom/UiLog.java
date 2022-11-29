package com.android.realize.unicom;

import android.util.Log;

public class UiLog {
    private static final String TAG = "UiLog";
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;

    public static void e(String tag, String msg) {
        Log.e(TAG, "[" + tag + "] : " + msg);
    }

    public static void d(String tag, String msg) {
        Log.d(TAG, "[" + tag + "] : " + msg);
    }

    public static void i(String tag, String msg) {
        Log.i(TAG, "[" + tag + "] : " + msg);
    }

    public static void w(String tag, String msg) {
        Log.w(TAG, "[" + tag + "] : " + msg);
    }

    public static void v(String tag, String msg) {
        Log.v(TAG, "[" + tag + "] : " + msg);
    }
}
