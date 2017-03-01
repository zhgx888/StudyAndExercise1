package com.example.dialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/5 0005.
 */

public class MCustomViewActivity extends Activity implements View.OnClickListener {
    TextView mTxtHandler;
    TextView mTxtNum;
    DrawView drawView = null;
    Memory memory;
    float num;
    int time = 0;
    private static final int GET_MSG_SUCCESS = 1;
    private static final int GET_MSG_FAILED = 2;
    ProgressDialog progressDialog;
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET_MSG_SUCCESS:
                    Bundle bundle = msg.getData();
                    String info = bundle.get("info").toString();
                    mTxtHandler.setText(info);
//                    progressDialog.dismiss();
                    break;
                case GET_MSG_FAILED:
                    break;
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        memory = new Memory(this);
        setContentView(R.layout.activity_customview);
        mTxtHandler = (TextView) findViewById(R.id.txt_handmsg);
        mTxtNum = (TextView) findViewById(R.id.txt_handmsg);
        drawView = (DrawView) findViewById(R.id.drawView);
        drawView.setParamsWithAnim(memory.separatePercentage());
        mTxtHandler.setOnClickListener(this);
        final Thread thread = new Thread() {
            public void run() {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("info", "" + memory.separatePercentage);
                msg.what = GET_MSG_SUCCESS;
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        };
        thread.start();
//        progressDialog=DialogUtils.progressDialog(MCustomViewActivity.this);
    }


    @Override
    public void onClick(View v) {
        time = drawView.time;
        if (time == 0) {
            time = 1;
            memory.killAllProcesses();
            num = memory.separatePercentage();
            drawView.setParamsWithAnim(num);
        }
//        Log.i("@@@@@@@","@@@@@@@@@@@@@@");
//
//                Log.i("@@@@@@@","###################");
//                memory.killAllProcesses();
//            num = memory.separatePercentage();
//            drawView.setParamsWithAnim(num);
//                try {
//                        Thread.sleep(1000);
//                    Log.i("@@@@@@@","!!!!!!!!!");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
    }
}
