package com.example.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/12/20 0020.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "SecondActivity";
    private Button bt1;
    private Button bt2;
    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pp);
        bt1= (Button) findViewById(R.id.back1);
        bt2= (Button) findViewById(R.id.back2);
        bt3= (Button) findViewById(R.id.back3);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        Log.i(TAG, "onCreate1");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause1");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop1");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy1");
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back1:
                Intent in=getIntent();;
                setResult(RESULT_OK, in);
                finish();
                break;
            case R.id.back2:
                in=getIntent();;
                setResult(RESULT_OK, in);
                finish();
                break;
            case R.id.back3:
                in=new Intent(SecondActivity.this,QQActivity.class);
                startActivity(in);
                break;
        }
    }

}
