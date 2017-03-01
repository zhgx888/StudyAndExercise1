package com.example.dialogs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/1/8 0008.
 */

public class DrawView2 extends View {
    public DrawView2(Context context) {
        super(context);
    }

    public DrawView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private RectF rf = null;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewWidch = MeasureSpec.getSize(widthMeasureSpec);
        int viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        rf = new RectF(1, 1, viewWidch-1, viewHeight-1);
    }

    private float fl = 0;
    private float flt = 0;
//    private float flRise = 0;
//    private float flFall = 0;

    public void setParansWithAnim(float fll) {
        this.fl = fll;
        Log.i("",fll+"");
        Log.i("",fl+"");
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                flt=flt+3;
                postInvalidate();
                if(flt>=360){
                    flt=360;
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 100, 100);

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


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        canvas.drawArc(rf,-90,flt,true,paint);
        if(flt>fl){
            Paint paints=new Paint();
            paints.setColor(Color.GREEN);
            paints.setAntiAlias(true);
            Log.i("***********",fl+"");
            canvas.drawArc(rf,fl-90,flt-fl,true,paints);
        }
    }
}
