package com.example.login.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.login.R;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAGG = "PageActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        textView = (TextView) findViewById(R.id.textView5);
        Log.i(TAGG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAGG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAGG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAGG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAGG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAGG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAGG, "onDestroy");
    }

    @Override
    public void onClick(View v) {

    }
}
