package com.example.dialogs;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.FileDescriptor;

/**
 * Created by Administrator on 2017/1/13 0013.
 */

public class MusicPlay implements MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {
    MediaPlayer mediaPlayer;
    boolean playing = false;
    FileDescriptor mfileDescriptor;
    Context mCtx;


    MusicPlay(Context context) {
        mCtx = context;
    }

//    MusicPlay(Context context, AssetFileDescriptor fileDescriptor) {
//        mediaPlayer = new MediaPlayer();
//        mfileDescriptor = fileDescriptor.getFileDescriptor();
////        mediaPlayer.setOnBufferingUpdateListener(this);
//    }

    private void startTimer() {
    }

    private void stopTimer() {
    }

    public void play() {
//        try {
//            mediaPlayer.reset();
//            mediaPlayer.setDataSource(mfileDescriptor);
//            mediaPlayer.prepare();
//            mediaPlayer.setOnPreparedListener(new PreparedListener(0));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(mCtx, R.raw.zxxpg);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }

    public boolean pause() {
        boolean i = mediaPlayer == null;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                playing = false;
            } else {
                mediaPlayer.start();
                playing = true;
            }
        }
        return playing;
    }

    public void replay() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(0);
        } else {
            play();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
//            stopTimer();
        }
    }


    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
//if ()
    }

    class PreparedListener implements MediaPlayer.OnPreparedListener {
        int mpostion = 0;

        PreparedListener(int postion) {
            mpostion = postion;
        }

        @Override
        public void onPrepared(MediaPlayer mp) {
//            startTimer();
            mp.start();
            mp.seekTo(mpostion);
        }

    }
}
