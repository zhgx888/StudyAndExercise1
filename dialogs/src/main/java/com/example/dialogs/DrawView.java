package com.example.dialogs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/1/5 0005.
 */

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private RectF rf = null;

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        rf = new RectF(0, 0, viewWidth, viewHeight);
    }

    private float flRise = 0;
    private float flFall = 0;
    private float flRaw = 0;
    public boolean flag;
    public int time;

    public void setParamsWithAnim(float fll) {
        time=1;
        this.flRaw = fll;
        /**
         * 1.位置判断方式停止
         */
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (flag) {
                    flFall = flFall - 3;
                    if (flFall <= 0) {
                        flRise = 0;
                        flag = false;
                    }
                } else {
                    flRise = flRise + 3;
                    if (flRise >= flRaw) {
                        flFall = flRaw;
                        flRise = flRaw;
                    }
                    if (flRise == flRaw) {
                        timer.cancel();
                        flag = true;
                        time = 0;
                    }
                }
                postInvalidate();
            }
        };
        timer.schedule(timerTask,10, 50);
        /**
         * 2.线程结束方式停止
         */
//        Thread thread = new Thread() {
//            public void run() {
//                while (!flag) {
//                    fl = fl + 4;
//                    postInvalidate();
//                    if (fl >= flRaw) {
//                        fl = flRaw;
//                    }
//                    if (fl == flRaw) {
//                        flag = true;
//                    }
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        };
//        thread.start();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(getResources().getColor(R.color.colorAccent));
        p.setAntiAlias(true);
        canvas.drawArc(rf, -90, flRise, true, p);
        if (flag) {
            p.setColor(getResources().getColor(R.color.colorPrimaryDark));
            p.setAntiAlias(true);
            canvas.drawArc(rf, flRise - 90, flFall - flRise, true, p);
        }

    }
}
