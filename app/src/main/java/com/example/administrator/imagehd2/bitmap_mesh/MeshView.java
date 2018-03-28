package com.example.administrator.imagehd2.bitmap_mesh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.imagehd2.R;

/**
 * Created by Administrator on 2018/3/28.
 */

public class MeshView extends View {
    //横向分格格数
    private static final int WIDTH = 200;
    //纵向分格格数
    private static final int HEIGHT = 200;
    private float K = 1;

    //交点个数
    private int COUNT = (WIDTH + 1) * (HEIGHT + 1);
    //点坐标 -- 一维数组表示 -- 奇数位x,偶数位y
    private float[] verts = new float[COUNT * 2];

    private float[] orig = new float[COUNT * 2];

    private Bitmap mBitmap;

    public MeshView(Context context) {
        super(context);
        initView();
    }

    public MeshView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MeshView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        int index = 0;

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        float bmWidth = mBitmap.getWidth();
        float bmHeight = mBitmap.getHeight();

        //取出交点横纵坐标值 置于一维数组保存
        for (int i = 0; i < HEIGHT + 1; i++) {
            float fy = bmHeight * i / HEIGHT;
            for (int j = 0; j < WIDTH + 1; j++) {
                float fx = bmWidth * j / WIDTH;
                orig[index * 2] = verts[index * 2] = fx;
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy + 200;
                index++;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < HEIGHT + 1; i++) {
            for (int j = 0; j < WIDTH + 1; j++) {
                verts[(i * (WIDTH + 1) + j) * 2] += 0;
                float offSetY = (float) Math.sin((float) j / WIDTH * 2 * Math.PI + K * 2 * Math.PI);
                verts[(i * (WIDTH + 1) + j) * 2 + 1] =
                        orig[(i * (WIDTH + 1) + j) * 2 + 1] + offSetY * 50;
            }
        }

        K += 0.1f;

        canvas.drawBitmapMesh(mBitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
        invalidate();
    }
}
