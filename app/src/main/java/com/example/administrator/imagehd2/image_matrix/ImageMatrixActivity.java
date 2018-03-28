package com.example.administrator.imagehd2.image_matrix;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.administrator.imagehd2.R;

/**
 * Created by Administrator on 2018/3/27.
 */

public class ImageMatrixActivity extends Activity {
    private GridLayout mGridLayout;
    private ImageMatrixView mImageMatrixView;
    private int mEtWidth, mEtHeight;
    private float[] mImageMatrix = new float[9];
    private EditText[] mEts = new EditText[9];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_image_matrix);
        mImageMatrixView = findViewById(R.id.view);
        mGridLayout = findViewById(R.id.grid_group);

        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGridLayout.getWidth() / 3;
                mEtHeight = mGridLayout.getHeight() / 3;
                addEts();
                initImageMatrix();

            }
        });
    }

    private void addEts() {
        for (int i = 0; i < 9; i++) {
            EditText et = new EditText(ImageMatrixActivity.this);
            et.setGravity(Gravity.CENTER);
            mEts[i] = et;
            mGridLayout.addView(et, mEtWidth, mEtHeight);
        }
    }

    private void initImageMatrix() {
        for (int i = 0; i < 9; i++) {
            if (i % 4 == 0) {
                mEts[i].setText(String.valueOf("1"));
            } else {
                mEts[i].setText(String.valueOf("0"));
            }
        }
    }

    private void getImageMatrix() {
        for (int i = 0; i < 9; i++) {
            EditText et = mEts[i];
            mImageMatrix[i] = Float.parseFloat(et.getText().toString());
        }
    }

    public void btnChange(View view) {
        getImageMatrix();
        Matrix matrix = new Matrix();

        matrix.setValues(mImageMatrix);
        mImageMatrixView.setImageMatrix(matrix);

    }

    public void btnReset(View view) {
        initImageMatrix();
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        mImageMatrixView.setImageMatrix(matrix);
    }
}
