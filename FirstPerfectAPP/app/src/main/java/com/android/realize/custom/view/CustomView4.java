package com.android.realize.custom.view;

import android.content.Context;
import android.graphics.BitmapShader;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.ComposePathEffect;
import android.graphics.ComposeShader;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SumPathEffect;
import android.graphics.SweepGradient;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;

public class CustomView4 extends View {
    private static final String TAG = "CustomView4";
    private Paint mPaint;
    private Path mPath;

    public CustomView4(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 关闭硬件加速器
        setLayerType(LAYER_TYPE_SOFTWARE, null);
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
        // Paint 的三层处理
        // 1. 设置颜色 ：mPaint.setColor(Color.BLACK);
        // 2. 设置Shader
        // 3. 设置ColorFilter
        // 使用Shader设置渐变色：不直接使用，通过他的5个子类识别。
        /**
         * 注意：在设置了 Shader 的情况下，Paint.setColor/ARGB() 所设置的颜色就不再起作用。
         * new LinearGradient(float x0, float y0, float x1, float y1,
         *             int color0, int color1,TileMode tile) :
         * 线性渐变，设置两个点和两个颜色、着色器模式(Shader.TileMode：着色器平铺模式，该值不能为空。
         * TileMode 一共有 4 个值可选： CLAMP，MIRROR ,REPEAT 和 DECAL。CLAMP 是夹层模式，
         * 会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式。)
         * BitmapShader() :
         * 位图着色器
         * ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode) ：
         * mode : 两个着色器的颜色结合模式 .
         * 参考文档：https://developer.android.com/reference/android/graphics/PorterDuff.Mode
         * 其中三个参数：
         * SRC_OVER，第二个覆盖到第一个；
         * DST_OUT，显示出第二章图片的蒙版抠图效果(第二章图片的轮廓，第一张图片的背景且只显示第二章轮廓的部分)
         * DST_IN ：在第一个图形的基础上显示出第二个图形的挖空效果
         * 混合着色器
         * RadialGradient() ：
         * 辐射渐变
         * SweepGradient() ：
         * 扫描渐变
         */
        Shader shader = new LinearGradient(100, 100, 400, 100, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        RectF rectF = new RectF(100, 100, 400, 400);
        canvas.drawRect(rectF, mPaint);

        shader = new LinearGradient(450, 100, 750, 100, Color.RED, Color.BLUE, Shader.TileMode.REPEAT);
        mPaint.setShader(shader);
        rectF = new RectF(450, 100, 750, 400);
        canvas.drawRect(rectF, mPaint);

        shader = new LinearGradient(100, 450, 400, 450, Color.RED, Color.BLUE, Shader.TileMode.MIRROR);
        mPaint.setShader(shader);
        rectF = new RectF(100, 450, 400, 750);
        canvas.drawRect(rectF, mPaint);

        shader = new LinearGradient(450, 450, 750, 750, Color.RED, Color.BLUE, Shader.TileMode.DECAL);
        mPaint.setShader(shader);
        rectF = new RectF(450, 450, 750, 750);
        canvas.drawRect(rectF, mPaint);

        // Shader shader = new BitmapShader();
        // Shader shader = new ComposeShader();
        // Shader shader = new RadialGradient();
        // Shader shader = new SweepGradient();
        // 颜色过滤器
        /**
         * ColorFilter 并不直接使用，而是使用它的子类.
         * BlendModeColorFilter :
         * LightingColorFilter :
         * 计算方式 R*mul.R/255 + add.R。
         * ColorMatrixColorFilter :
         * PorterDuffColorFilter :
         */
        // ColorFilter blendModeColorFilter = new BlendModeColorFilter();
        // ColorFilter lightingColorFilter = new LightingColorFilter();
        // ColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter()
        // ColorFilter porterDuffColorFilter = new PorterDuffColorFilter()
        // 设置色彩抖动(主要在像素降低时使用)
        mPaint.setDither(true);
        // 给图形的轮廓设计效果
        /**
         * 单一效果：
         * CornerPathEffect :
         * DiscretePathEffect :
         * DashPathEffect :
         * PathDashPathEffect :
         * 组合效果：
         * SumPathEffect
         * ComposePathEffect
         */
        PathEffect cornerPathEffect = new CornerPathEffect(20);
        PathEffect discretePathEffect = new DiscretePathEffect(3, 2);
        PathEffect dashPathEffect = new DashPathEffect(new float[]{2, 3}, 2);
        PathEffect pathDashPathEffect = new PathDashPathEffect(null, 2, 2, PathDashPathEffect.Style.ROTATE);
        // PathEffect sumPathEffect = new SumPathEffect(20);
        // PathEffect composePathEffect = new ComposePathEffect(20);
        // mPaint.setPathEffect(cornerPathEffect);
        // mPaint.getFillPath();
    }
}
