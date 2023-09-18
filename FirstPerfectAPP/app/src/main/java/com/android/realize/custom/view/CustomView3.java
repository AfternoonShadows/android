package com.android.realize.custom.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


public class CustomView3 extends View {
    private static final String TAG = "CustomView3";
    private Paint mPaint;
    private Path mPath;

    public CustomView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();
    }
}
