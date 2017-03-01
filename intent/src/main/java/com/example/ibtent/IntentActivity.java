package com.example.ibtent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "IntentActivity";
    private Button mjump1Bt;
    private Button mjump2Bt;
    private Button mcall1Bt;
    private Button mcall2Bt;
    private Button mtextBt;
    private Button maddpicBt;
    TextView mTxtXianshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);
        mjump1Bt = (Button) findViewById(R.id.jump1);
        mjump2Bt = (Button) findViewById(R.id.jump2);
        mcall1Bt = (Button) findViewById(R.id.call1);
        mcall2Bt = (Button) findViewById(R.id.call2);
        mtextBt = (Button) findViewById(R.id.texting);
        maddpicBt= (Button) findViewById(R.id.addpic);
        mTxtXianshi= (TextView) findViewById(R.id.Xianshi);
        mjump1Bt.setOnClickListener(this);
        mjump2Bt.setOnClickListener(this);
        mcall1Bt.setOnClickListener(this);
        mcall2Bt.setOnClickListener(this);
        mtextBt.setOnClickListener(this);
        maddpicBt.setOnClickListener(this);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestrat");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStrop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.jump1:
                intent.setClass(IntentActivity.this, JumpActivity.class);
                Bundle bundle=new Bundle();
                String str1="yes";
                bundle.putString("ok", str1);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1000);
                break;
            case R.id.jump2:
                Log.i("HelloWorldActivity","onClick");
                intent.setAction("edu.feicui.action");
                startActivity(intent);
            case R.id.call1://需要在manifests里面添加权限
                Uri uri = Uri.parse("tel:15262045679");
                intent.setAction(intent.ACTION_CALL);//设置操作为打电话
                intent.setData(uri);//通过Uri设置电话号码
                startActivity(intent);
                break;
            case R.id.call2:
                intent.setAction(intent.ACTION_DIAL);//设置操作为打电话
                intent.setData(Uri.parse("tel:10086"));//通过Uri设置电话号码;
                startActivity(intent);
                break;
            case R.id.texting:
                intent.setAction(intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:10086"));
                intent.putExtra("sms_body","发送的短信内容");//"sms_body"固定用法
                startActivity(intent);
                break;
            case R.id.addpic:
                intent.setType("image/*");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,1000);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==1000){
                Bundle bundel=data.getExtras();
                String result=bundel.getString("完成");
                mTxtXianshi.setText(result);
            }
        }
    }
}
