package com.github.kevin.library;

import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 模仿Path系统工具类的设计
 * 存储一系列指令：moveTo/lineTo/cubicTo(x,y等参数)
 */
public class AnimPath {
    private List<PathPoint> mPathPointList = new ArrayList<>();
    private View mView;

    public void moveTo(float x, float y) {
        mPathPointList.add(PathPoint.moveTo(x, y));
    }

    public void lineTo(float x, float y) {
        mPathPointList.add(PathPoint.lineTo(x, y));
    }

    //三阶贝塞尔曲线
    public void cubicTo(float X1, float Y1, float X2, float Y2, float eX, float eY) {
        mPathPointList.add(PathPoint.cubicTo(X1, Y1, X2, Y2, eX, eY));
    }

    //开启属性动画
    public void startAnimation(View view, int duration) {
        mView = view;
//        //以下两句代码产生匀速斜线运动的效果
//        ObjectAnimator.ofFloat(view, "TranslationX", 0, 100);
//        ObjectAnimator.ofFloat(view, "TranslationY", 0, 100);

        //属性动画原理：通过反射不断调用View的setTranslationX()和setTranslationX()方法
        //属性动画：本质是控制一个对象身上的任何属性值以及setXXX()方法。 ---- 反射setTranslationX()，setAlpha()
        ObjectAnimator animator = ObjectAnimator.ofObject(this, "testMethod", new PathEvaluator(), mPathPointList.toArray());
        animator.setDuration(duration);
        animator.start();
    }

    public void setTestMethod(PathPoint p) {
        mView.setTranslationX(p.mX);
        mView.setTranslationY(p.mY);
    }

}
