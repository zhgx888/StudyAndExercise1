package com.example.ibtent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/12/22 0022.
 */

public class JumpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbackBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        mbackBt= (Button) findViewById(R.id.back);
       mbackBt.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent=getIntent();
        Bundle bundle=new Bundle();
        bundle.putString("ok","yingying");
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);//intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
        finish();//此处一定要调用finish()方法
    }


}
