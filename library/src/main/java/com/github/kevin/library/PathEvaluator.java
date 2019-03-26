package com.github.kevin.library;

import android.animation.TypeEvaluator;

/**
 * 估值计算器
 */
public class PathEvaluator implements TypeEvaluator<PathPoint> {
    private float x;
    private float y;

    /**
     * @param fraction   动画执行的百分比
     * @param startValue
     * @param endValue
     * @return
     */
    @Override
    public PathPoint evaluate(float fraction, PathPoint startValue, PathPoint endValue) {
        switch (endValue.mOperation) {
            case PathPoint.MOVE:
                x = endValue.mX;
                y = endValue.mY;
                break;
            case PathPoint.LINE:
                x = startValue.mX + (endValue.mX - startValue.mX) * fraction;
                y = startValue.mY + (endValue.mY - startValue.mY) * fraction;
                break;
            case PathPoint.CUBIC:
                float t = 1 - fraction;
                x = t * t * t * startValue.mX +
                        3 * fraction * t * t * endValue.X1 +
                        3 * endValue.X2 * fraction * fraction * t +
                        fraction * fraction * fraction * endValue.mX;
                y = t * t * t * startValue.mY +
                        3 * fraction * t * t * endValue.Y1 +
                        3 * endValue.Y2 * fraction * fraction * t +
                        fraction * fraction * fraction * endValue.mY;
                break;
        }
        return PathPoint.moveTo(x, y);
    }
}
