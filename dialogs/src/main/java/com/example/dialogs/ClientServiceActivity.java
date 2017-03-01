package com.example.dialogs;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ClientServiceActivity extends AppCompatActivity {
    Button mBtnClient;
    Intent intent;
    boolean bind = false;
    static final int MSG_REGISTER_CLIENT=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_server);
        mBtnClient = (Button) findViewById(R.id.btn_client);
        intent = new Intent();
        intent.getAction();
        intent.getPackage();
        mBtnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bind) {
                    unbindService(conn);
                }
            }
        });
    }
    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bind=true;
            Messenger serviceMessenger=new Messenger(service);

        }
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    Handler clientHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_REGISTER_CLIENT:
                    String hello=msg.getData().getString("hello");
                    break;
            }
            super.handleMessage(msg);
        }
    };
    Messenger clientMessenger=new Messenger(clientHandler);
}
