package com.android.realize.unicom;

import android.util.Log;

public class UiLog {
    private static final String TAG = "UiLog";
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;

    public static void e(String tag, String msg) {
        Log.e(TAG, "[" + tag + "] : " + msg);
    }

    public static void e(Object tag, String msg) {
        Log.d(TAG, "[" + getPrefixFromObject(tag) + "] : " + ": " + msg);
    }

    public static void d(String tag, String msg) {
        Log.d(TAG, "[" + tag + "] : " + msg);
    }

    public static void d(Object tag, String msg) {
        Log.d(TAG, "[" + getPrefixFromObject(tag) + "] : " + ": " + msg);
    }

    public static void i(String tag, String msg) {
        Log.i(TAG, "[" + tag + "] : " + msg);
    }

    public static void i(Object tag, String msg) {
        Log.d(TAG, "[" + getPrefixFromObject(tag) + "] : " + ": " + msg);
    }

    public static void w(String tag, String msg) {
        Log.w(TAG, "[" + tag + "] : " + msg);
    }

    public static void w(Object tag, String msg) {
        Log.d(TAG, "[" + getPrefixFromObject(tag) + "] : " + ": " + msg);
    }

    public static void v(String tag, String msg) {
        Log.v(TAG, "[" + tag + "] : " + msg);
    }

    public static void v(Object tag, String msg) {
        Log.d(TAG, "[" + getPrefixFromObject(tag) + "] : " + ": " + msg);
    }

    private static String getPrefixFromObject(Object obj) {
        return obj == null ? "<null>" : obj.getClass().getSimpleName();
    }
    /**
     * 一般会添加一个boolean型的方法，用来判断权限是否开启，
     * 如果开启可以打印log一般会添加一个boolean型的方法，
     * 用来判断权限是否开启，如果开启可以打印log.
     */

}
