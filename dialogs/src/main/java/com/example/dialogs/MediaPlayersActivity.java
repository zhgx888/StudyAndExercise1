package com.example.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MediaPlayersActivity extends AppCompatActivity implements View.OnClickListener {
    Context mCtx;
    TextView mBtnPlay, mBtnPause, mBtnReplay, mBtnStop;
    MusicPlay musicPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx=this;
        musicPlay =new MusicPlay(mCtx);
        setContentView(R.layout.activity_media_players);
        mBtnPlay = (TextView) findViewById(R.id.btn_play);
        mBtnPause = (TextView) findViewById(R.id.btn_pause);
        mBtnReplay = (TextView) findViewById(R.id.btn_replay);
        mBtnStop = (TextView) findViewById(R.id.btn_stop);
        mBtnPlay.setOnClickListener(this);
        mBtnPause.setOnClickListener(this);
        mBtnReplay.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                musicPlay.play();
                break;
            case R.id.btn_pause:
                musicPlay.pause();
                break;
            case R.id.btn_replay:
                musicPlay.replay();
                break;
            case R.id.btn_stop:
                musicPlay.stop();
                break;
        }
    }
}
