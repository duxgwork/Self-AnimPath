package com.github.kevin.anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.kevin.library.AnimPath;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPress(View view) {
        AnimPath animPath = new AnimPath();
        animPath.moveTo(0, 0);//起始点位置（相对坐标）
        animPath.cubicTo(-200, -200, -300, 0, -400, -400);
        animPath.cubicTo(-500, 300, -600, 200, -700, 0);
        animPath.lineTo(0, 0);//回到起始点位置
        animPath.startAnimation(view, 2000);
    }
}