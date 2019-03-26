package com.github.kevin.library;

public class PathPoint {
    //定义三种指令类型
    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CUBIC = 2;//三阶贝塞尔曲线

    int mOperation;//运动方向
    float mX, mY;  //指令坐标
    float X1, Y1;  //控制点1
    float X2, Y2;  //控制点2

    private PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    private PathPoint(int operation, float X1, float Y1, float X2, float Y2, float eX, float eY) {
        mOperation = operation;
        this.mX = eX;
        this.mY = eY;
        this.X1 = X1;
        this.Y1 = Y1;
        this.X2 = X2;
        this.Y2 = Y2;
    }

    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }

    public static PathPoint lineTo(float x, float y) {
        return new PathPoint(LINE, x, y);
    }

    public static PathPoint cubicTo(float X1, float Y1, float X2, float Y2, float eX, float eY) {
        return new PathPoint(CUBIC, X1, Y1, X2, Y2, eX, eY);
    }

}