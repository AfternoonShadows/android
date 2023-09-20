package com.android.realize.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 黑桃形状
        mPath.addArc(100, 100, 300, 300, -225, 225);
        // 画弧并不使用当前节点作为起始点
        mPath.arcTo(300, 100, 500, 300, -180, 225, false);
        mPath.lineTo(300, 442);
        // 封闭当前图形，如果未封闭，会添加一条直线。等价于 path.lineTo(起点坐标)
        mPath.close();
        // (当需要填充图形时（即 Paint.Style 为 FILL 或 FILL_AND_STROKE），Path 会自动封闭子图形)
        canvas.drawPath(mPath, mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);

        canvas.drawPoints(new float[]{100, 100
                , 300, 300
                , 300, 100,
                500, 300}, mPaint);

        // 清空对Path做出的操作,包括线和弧，但是对填充物作出修改(如果不设置，则上述画出的黑桃形状会再次被绘画)
        mPath.reset();

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        // 画圆 (Path.Direction.CW:顺时针旋转，Path.Direction.CWW:逆时针旋转)
        mPath.addCircle(600, 200, 100, Path.Direction.CW);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();
        // 添加椭圆
        RectF rectF = new RectF();
        mPath.addOval(rectF, Path.Direction.CCW);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();
        // 添加矩形
        mPath.addRect(rectF, Path.Direction.CCW);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();
        // 添加圆角矩形
        mPath.addRoundRect(rectF, 10, 10, Path.Direction.CCW);
        canvas.drawPath(mPath, mPaint);
        mPath.reset();
        // 添加另一个Path
        /**
         * 设置图形相互交叉时的填充规则.
         * WINDING : 默认
         * EVEN_ODD :
         * INVERSE_WINDING :
         * INVERSE_EVEN_ODD :
         */
        mPath.setFillType(Path.FillType.WINDING);
    }
}
