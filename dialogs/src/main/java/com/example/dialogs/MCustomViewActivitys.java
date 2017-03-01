package com.example.dialogs;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

/**
 * Created by Administrator on 2017/1/5 0005.
 */

public class MCustomViewActivitys extends Activity {
    Memory memory;
    DrawView2 drawView2 = null;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memory=new Memory(this);
        setContentView(R.layout.activity_customviews);
        drawView2 = (DrawView2) findViewById(R.id.dv_Arc);
        drawView2.setParansWithAnim(memory.dataAndExternalStoragePercentage());


    }


}
