package com.example.administrator.imagehd2.reflect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.imagehd2.R;

/**
 * Created by Administrator on 2018/3/28.
 */

public class ReflectView extends View {

    private Bitmap mSrcBitmap;
    private Bitmap mReflectBitmap;
    private Paint mPaint;

    public ReflectView(Context context) {
        super(context);
        initView();
    }

    public ReflectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ReflectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        Matrix matrix = new Matrix();
        //x = x0;y = -y0
        matrix.setScale(1, -1);//x轴对称

        mReflectBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(), mSrcBitmap.getHeight(), matrix, true);

        mPaint = new Paint();
        //设置线性渐变 从不透明到透明
        mPaint.setShader(new LinearGradient(0, mSrcBitmap.getHeight(), 0, 1.5f * mSrcBitmap.getHeight(),
                0xdd000000, 0x10000000, Shader.TileMode.CLAMP));
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(mSrcBitmap, 0, 0, null);
        canvas.drawBitmap(mReflectBitmap, 0, mSrcBitmap.getHeight(), null);
        canvas.drawRect(0, mReflectBitmap.getHeight(), mReflectBitmap.getWidth(), 2 * mReflectBitmap.getHeight(), mPaint);
    }
}
