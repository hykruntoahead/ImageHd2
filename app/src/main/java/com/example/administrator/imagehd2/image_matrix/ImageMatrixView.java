package com.example.administrator.imagehd2.image_matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.imagehd2.R;

/**
 * Created by Administrator on 2018/3/27.
 */

public class ImageMatrixView extends View {
    private Bitmap mBitmap;
    private Matrix mMatrix;

    public ImageMatrixView(Context context) {
        super(context);
        initView();
    }

    public ImageMatrixView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ImageMatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mMatrix = new Matrix();
    }

    public void setImageMatrix(Matrix matrix) {
        mMatrix = matrix;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //原图
        canvas.drawBitmap(mBitmap, 0, 0, null);
        //对比图
        canvas.drawBitmap(mBitmap,mMatrix,null);
    }
}
