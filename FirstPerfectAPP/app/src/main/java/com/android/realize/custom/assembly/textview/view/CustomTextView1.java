package com.android.realize.custom.assembly.textview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.android.realize.unicom.UiLog;

public class CustomTextView1 extends View {
    private static final String TAG = "CustomTextView1";
    private Paint mPaintFrame;
    private Paint mPaintCharacters;

    public CustomTextView1(Context context) {
        super(context);
    }

    public CustomTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        UiLog.d(TAG, "context :" + context + " attrs" + attrs);
        mPaintFrame = new Paint();
        mPaintFrame.setColor(Color.BLACK);
        mPaintFrame.setStrokeWidth(5);
        mPaintFrame.setStyle(Paint.Style.STROKE);

        mPaintCharacters = new Paint();
        mPaintCharacters.setColor(Color.BLACK);
        mPaintCharacters.setTextSize(50);
        mPaintCharacters.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(100, 100, 500, 200);
        canvas.drawRect(rectF, mPaintFrame);
        canvas.drawText("How are you ?", 110, 160, mPaintCharacters);
    }
}
