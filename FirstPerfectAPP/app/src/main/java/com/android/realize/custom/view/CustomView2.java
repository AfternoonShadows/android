package com.android.realize.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.android.realize.unicom.UiLog;

public class CustomView2 extends View {
    private static final String TAG = "CustomView2";
    private int color = 0;
    private String text = "hello my view";
    // 创建画笔
    private Paint mPaint;

    public CustomView2(Context context) {
        super(context);
        UiLog.d(TAG, "CustomView1 : context = " + context);
    }

    public CustomView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        UiLog.d(TAG, "CustomView1 : context = " + context
                + " attrs = " + attrs);
        mPaint = new Paint();
        // 设置画笔颜色
        mPaint.setColor(Color.BLACK);
        // 设置画笔样式
        mPaint.setStyle(Paint.Style.FILL);
        // 设置文字大小
        mPaint.setTextSize(35.0f);
        // 设置画笔宽度
        mPaint.setStrokeWidth(15f);
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
        // TODO 疑问：是否可以绘制外边框
        // 绘制背景颜色
        canvas.drawColor(Color.WHITE);
        // 绘制一个点
        // TODO 疑问 ：子视图里面的坐标是否只是1相对于子视图，还是整个视图。
        canvas.drawPoint(100, 200, mPaint);
        // 绘制一组点
        canvas.drawPoints(new float[]{50, 50
                , 50, 80,
                50, 100}, mPaint);
        // 绘制一条线（在坐标（200,100）和坐标（400，100）之间绘制）
        canvas.drawLine(200, 100, 400, 100, mPaint);
        // 绘制一组线
        canvas.drawLines(new float[]{200, 100, 200, 400
                , 200, 100, 400, 300}, mPaint);
        // 绘制矩形 : 1.（左上角的点（10,400），右上角的点（100,490））
        canvas.drawRect(10, 400, 100, 490, mPaint);
        // 2. 矩形绘制的第二种方案（Rect是整形的int）
        Rect rect = new Rect(130, 400, 230, 490);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20f);
        canvas.drawRect(rect, mPaint);
        // 2. 矩形绘制的第三种方案(RectF是单精度型的float)
        RectF rectF = new RectF(250, 400, 350, 490);
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rectF, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10f);

        // 绘制圆角矩形(rx,ry代表x轴的半径和在y轴的半径)(注:大于一半是无法绘制的所以会自动修正当长度大于一半时按照长度的2一半绘制)
        rectF = new RectF(10, 530, 210, 630);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(rectF, 100, 50, mPaint);
        // 绘制圆形(前面两个参数是圆心坐标，第三个参数是半径)
        canvas.drawCircle(410,600,50,mPaint);
    }
}
