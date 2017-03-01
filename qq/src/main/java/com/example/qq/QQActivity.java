package com.example.qq;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class QQActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG="QQActivity";
    private Button mjumpBt;
    private TextView mtextView1;
    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//创建
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq);
        mjumpBt=(Button) findViewById(R.id.jump);
        mtextView1=(TextView) findViewById(R.id.textView);
        mjumpBt.setOnClickListener(this);
        mtextView1.setOnClickListener(this);
//        mjumpBt.setOnClickListener(new JumpListerner(this));
//        new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(QQActivity.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        }
        Log.i(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        flag=;
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jump:
                Intent intent=new Intent(QQActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.textView:
                Toast.makeText(QQActivity.this,"文本显示",Toast.LENGTH_LONG).show();
                break;
        }
    }
//    View.OnClickListener jumLisener=new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//
//        }
//    };
}

