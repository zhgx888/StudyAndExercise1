package com.example.jisuanqi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jisuanqi.R;

public class JisuanqiActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mjumpBtOne;
    private Button mjumpBtTwo;
    private Button mjumpBtThree;
    private Button mjumpBtFour;
    private Button mjumpBtFive;
    private Button mjumpBtSix;
    private Button mjumpBtSeven;
    private Button mjumpBtEight;
    private Button mjumpBtNine;
    private Button mjumpBtZero;
    private Button mjumpBtPlus;
    private Button mjumpBtMinus;
    private Button mjumpBtMul;
    private Button mjumpBtDiv;
    private Button mjumpBtEqu;
    private Button mjumpBtPoint;
    private Button mjumpBtMc;
    private EditText meditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jisuanqi);
        mjumpBtOne = (Button) findViewById(R.id.one);
        mjumpBtTwo = (Button) findViewById(R.id.two);
        mjumpBtThree = (Button) findViewById(R.id.three);
        mjumpBtFour = (Button) findViewById(R.id.four);
        mjumpBtFive = (Button) findViewById(R.id.five);
        mjumpBtSix = (Button) findViewById(R.id.six);
        mjumpBtSeven = (Button) findViewById(R.id.seven);
        mjumpBtEight = (Button) findViewById(R.id.eight);
        mjumpBtNine = (Button) findViewById(R.id.nine);
        mjumpBtZero = (Button) findViewById(R.id.zero);
        mjumpBtPlus = (Button) findViewById(R.id.plus);
        mjumpBtMinus = (Button) findViewById(R.id.minus);
        mjumpBtMul = (Button) findViewById(R.id.mul);
        mjumpBtDiv = (Button) findViewById(R.id.div);
        mjumpBtEqu = (Button) findViewById(R.id.equ);
        mjumpBtPoint = (Button) findViewById(R.id.point);
        mjumpBtMc = (Button) findViewById(R.id.mc);
        meditText = (EditText) findViewById(R.id.edittext);
        mjumpBtOne.setOnClickListener(this);
        mjumpBtTwo.setOnClickListener(this);
        mjumpBtThree.setOnClickListener(this);
        mjumpBtFour.setOnClickListener(this);
        mjumpBtFive.setOnClickListener(this);
        mjumpBtSix.setOnClickListener(this);
        mjumpBtSeven.setOnClickListener(this);
        mjumpBtEight.setOnClickListener(this);
        mjumpBtNine.setOnClickListener(this);
        mjumpBtZero.setOnClickListener(this);
        mjumpBtPlus.setOnClickListener(this);
        mjumpBtMinus.setOnClickListener(this);
        mjumpBtMul.setOnClickListener(this);
        mjumpBtDiv.setOnClickListener(this);
        mjumpBtEqu.setOnClickListener(this);
        mjumpBtPoint.setOnClickListener(this);
        mjumpBtMc.setOnClickListener(this);
        meditText.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override

    public void onClick(View v) {
switch (v.getId()){
    case R.id.one:
        int i=1;

        break;
}
    }
}