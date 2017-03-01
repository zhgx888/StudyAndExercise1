package com.example.dialogs;


import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/2/4 0004.
 */

public class ServiceServer extends Service {
    private static final int HELLO = 1;
    static final int MSG_REGISTER_CLIENT = 2;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return serverMessenger.getBinder();
    }

    Handler serverHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Messenger clientMessenager = msg.replyTo;
            switch (msg.what) {
                case HELLO:
                    try {
                        Message message = Message.obtain(null, MSG_REGISTER_CLIENT);
                        Bundle data = new Bundle();
                        data.putString("hello", "thank you");
                        message.setData(data);
                        clientMessenager.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
            }
            super.handleMessage(msg);
        }
    };
    Messenger serverMessenger=new Messenger(serverHandler);
}
