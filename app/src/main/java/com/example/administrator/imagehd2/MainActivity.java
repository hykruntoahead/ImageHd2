package com.example.administrator.imagehd2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.imagehd2.bitmap_mesh.MeshActivity;
import com.example.administrator.imagehd2.bitmap_shader.BitmapShaderActivity;
import com.example.administrator.imagehd2.image_matrix.ImageMatrixActivity;
import com.example.administrator.imagehd2.reflect.ReflectActivity;
import com.example.administrator.imagehd2.round_rect_xfermode.RoundRectXfromodeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnMatrix(View view) {
        startActivity(new Intent(this, ImageMatrixActivity.class));
    }


    public void btnXfromode(View view) {
        startActivity(new Intent(this, RoundRectXfromodeActivity.class));
    }

    public void btnShader(View view) {
        startActivity(new Intent(this, BitmapShaderActivity.class));
    }

    public void btnReflect(View view) {
        startActivity(new Intent(this, ReflectActivity.class));
    }

    public void btnMesh(View view) {
        startActivity(new Intent(this, MeshActivity.class));
    }
}
