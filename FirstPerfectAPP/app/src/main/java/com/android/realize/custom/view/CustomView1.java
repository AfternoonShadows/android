package com.android.realize.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.android.realize.unicom.UiLog;

public class CustomView1 extends View {
    private static final String TAG = "customView1";
    private int color = 0;
    private String text = "hello my view";
    private Paint mPaint;

    public CustomView1(Context context) {
        super(context);
        UiLog.d(TAG, "CustomView1 : context = " + context);
    }

    public CustomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        UiLog.d(TAG, "CustomView1 : context = " + context
                + " attrs = " + attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(35.0f);
        setPadding(20, 60, 0, 0);
    }

    // 1.测量view大小

    /**
     * 一个MeasureSpec由大小和模式组成
     * 它有三种模式：UNSPECIFIED(未指定),父元素部队自元素施加任何束缚，子元素可以得到任意想要的大小;
     * EXACTLY(完全)，父元素决定自元素的确切大小，子元素将被限定在给定的边界里而忽略它本身大小；
     * AT_MOST(至多)，子元素至多达到指定大小的值。
     * 　　它常用的三个函数：
     * 1.static int getMode(int measureSpec):根据提供的测量值(格式)提取模式(上述三个模式之一)
     * 2.static int getSize(int measureSpec):根据提供的测量值(格式)提取大小值(这个大小也就是我们通常所说的大小)
     * 3.static int makeMeasureSpec(int size,int mode):根据提供的大小值和模式创建一个测量值(格式)
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            // Measure the text
            result = (int) mPaint.measureText(text) + getPaddingLeft() + getPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        UiLog.d(TAG, "measureWidth: specMode=" + specMode + ", specSize=" + specSize + ", result=" + result);

        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        int mAscent = (int) mPaint.ascent();
        UiLog.d(TAG, "measureHeight: specMode=" + specMode + ", specSize=" + specSize);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            // Measure the text (beware: ascent is a negative number)
            result = (int) (-mAscent + mPaint.descent()) + getPaddingTop() + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by
                // measureSpec
                result = Math.min(result, specSize);
            }
        }
        //result = specSize;
        UiLog.d(TAG, "measureHeight: mAscent=" + mAscent + ", mDescent=" + mPaint.descent() + ", result=" + result);
        return result;
    }

    // 2.确定view大小
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    // 3.确定子view布局(自定义view包含子View时有用)
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    // 4.实际绘制内容
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        UiLog.d(TAG, "onDraw");
        canvas.drawText(text, getPaddingLeft(), getPaddingTop(), mPaint);
    }

    public void setText(String text) {
        this.text = text;
        // 刷新文本
        invalidate();
    }
}
