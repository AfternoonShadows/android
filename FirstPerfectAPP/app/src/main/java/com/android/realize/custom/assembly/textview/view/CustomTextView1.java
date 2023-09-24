package com.android.realize.custom.assembly.textview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;

import com.android.realize.unicom.UiLog;

import java.util.Locale;

public class CustomTextView1 extends View {
    private static final String TAG = "CustomTextView1";
    private Paint mPaintFrame;
    private Paint mPaintCharacters;
    private String mText = "How are you ?";

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
        // 设置文字类型
        // mPaintCharacters.setTypeface(Typeface.DEFAULT);
        // 是否使用伪粗体
        // mPaintCharacters.setFakeBoldText(false);
        // 设置下划线
        // mPaintCharacters.setUnderlineText(false);
        // 设置删除线
        // mPaintCharacters.setStrikeThruText(false);
        // 设置倾斜度
        // mPaintCharacters.setTextSkewX(0f);
        // 设置字符间距
        // mPaintCharacters.setLetterSpacing(0f);
        // 设置文字的对齐方式:三种。
        // mPaintCharacters.setTextAlign(Paint.Align.CENTER);
        // 设置文字的地域
        // mPaintCharacters.setTextLocale(Locale.CHINA);
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
        UiLog.d(TAG, "length = " + mText.length());
        canvas.drawRect(rectF, mPaintFrame);
        // canvas.drawText()不能换行
        // 绘制文字,x,y为左下角坐标
        canvas.drawText(mText, 110, 160, mPaintCharacters);
        // 换行使用StaticLayout
        // StaticLayout staticLayout = new StaticLayout(mText,mPaintCharacters);
        // 获取文字行间距（不使用StaticLayout时，自动换行时y轴坐标加上他）相邻两行文字间baseline的距离
        UiLog.d(TAG, "Font height : " + mPaintCharacters.getFontSpacing());
        // 获取文字的各种基线
        /**
         * top:所有字符的最大高度
         * ascent: 单间距字符的最大高度
         * descent:单间距字符，低于基线的建议距离
         * bottom:所有字符，低于基线的建议距离
         * leading:建议在文本行之间添加的额外空间
         */
        Paint.FontMetrics metrics = new Paint.FontMetrics();
        // 获取文字显示的范围
        Rect bounds = new Rect();
        UiLog.d(TAG, "bounds : " + bounds.toString());
        mPaintCharacters.getTextBounds(mText, 0, mText.length(), bounds);
        UiLog.d(TAG, "bounds1 : " + bounds.toString());
        bounds.left += 110;
        bounds.right += 110;
        bounds.top += 160;
        bounds.bottom += 160;
        UiLog.d(TAG, "bounds2 : " + bounds.toString());
        mPaintFrame.setColor(Color.BLUE);
        canvas.drawRect(bounds, mPaintFrame);
        // 测量文字的宽度
        float fontWidth = mPaintCharacters.measureText(mText);
        UiLog.d(TAG, "font width : " + fontWidth);
        int distance = (int) ((fontWidth - (bounds.right - bounds.left)) / 2);
        bounds.left -= 10;
        bounds.right += 10;
        UiLog.d(TAG, "bounds4 : " + bounds.toString());
        mPaintFrame.reset();
        mPaintFrame.setStyle(Paint.Style.STROKE);
        mPaintFrame.setColor(Color.RED);
        canvas.drawRect(bounds, mPaintFrame);
        // 根据长度显示部分字符
        float[] measuredWidth = {0};
        int textLength = mPaintCharacters.breakText(mText, true, 500 - 100, measuredWidth);
        UiLog.d(TAG, "display length : " + textLength);
        canvas.drawText(mText, 0, textLength, 110, 260, mPaintCharacters);
        canvas.drawText("asfasgbhasvdatgdyqwtgdyuatgduysa", 0, textLength, 110, 360, mPaintCharacters);

    }
}
