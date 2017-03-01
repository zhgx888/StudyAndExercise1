package com.example.adapters.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.adapters.R;

/**
 * Created by Administrator on 2016/12/22 0022.
 */

public class HomesActivity extends AppCompatActivity implements View.OnClickListener {
    Button mBtnSimple1;
    Button mBtnSimple2;
    Button mBtnArray;
    Button mBtnCustoms;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);
        mBtnSimple1 = (Button) findViewById(R.id.simple1);
        mBtnSimple2 = (Button) findViewById(R.id.simple2);
        mBtnArray = (Button) findViewById(R.id.array);
        mBtnCustoms = (Button) findViewById(R.id.customs);
        mBtnSimple1.setOnClickListener(this);
        mBtnSimple2.setOnClickListener(this);
        mBtnArray.setOnClickListener(this);
        mBtnCustoms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.simple1:
                intent = new Intent(HomesActivity.this, CustomSimpleAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.simple2:
                intent = new Intent(HomesActivity.this, SimplesAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.array:
                intent = new Intent(HomesActivity.this, ArrayAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.customs:
                intent = new Intent(HomesActivity.this, CustomAdapterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
