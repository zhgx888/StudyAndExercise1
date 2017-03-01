package com.example.dialogs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class AppShowActivity extends AppCompatActivity {
    ListView mLst;
    ProgressBar mPrg;
    CheckBox mChk;
    Context mCtx;
    ArrayList<AppInfo> mAppInfos;
    Button mBtn;
    AppShowAdapter appShowAdapter;
    private AppDelRecevice appDelRecevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = this;
        setContentView(R.layout.activity_app_show);
        mLst = (ListView) findViewById(R.id.soft_lst);
        mPrg = (ProgressBar) findViewById(R.id.soft_prg);
        mChk = (CheckBox) findViewById(R.id.chk_all);
        mBtn = (Button) findViewById(R.id.btn_del);
        asynLoadApp();
        mChk.setOnCheckedChangeListener(changeAllListener);
        mBtn.setOnClickListener(onScrollListener);
        // 注册广播接收器
        appDelRecevice = new AppDelRecevice();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        filter.addDataScheme("package");
        filter.addAction(AppDelRecevice.ACTION_APPDEL);
        registerReceiver(appDelRecevice, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(appDelRecevice);
    }

    public void asynLoadApp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                AppShow appShow = new AppShow();
                mAppInfos = appShow.getappInfos(mCtx);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mLst.setVisibility(View.VISIBLE);
                        mPrg.setVisibility(View.INVISIBLE);
                        appShowAdapter = new AppShowAdapter(mCtx, mAppInfos);
                        mLst.setAdapter(appShowAdapter);
                    }
                });
            }
        }).start();
    }

    private CompoundButton.OnCheckedChangeListener changeAllListener = new CompoundButton
            .OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            AppShowAdapter appListAdapter = (AppShowAdapter) mLst.getAdapter();
            List<AppInfo> appInfos = appListAdapter.mAppInfos;
            if (isChecked) {
                for (AppInfo appInfo : appInfos) {
                    appInfo.isDel = isChecked;
                }
            } else {
                for (AppInfo appInfo : appInfos) {
                    appInfo.isDel = isChecked;
                }
            }
            appShowAdapter.notifyDataSetChanged();
        }
    };

    private View.OnClickListener onScrollListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.btn_del:
                    AppShowAdapter appShowAdapter = (AppShowAdapter) mLst.getAdapter();
                    List<AppInfo> appInfos = appShowAdapter.mAppInfos;
                    for (AppInfo appInfo : appInfos) {
                        if (appInfo.isDel) {
                            String packageName = appInfo.packageInfo.packageName;
                            Intent intent = new Intent(Intent.ACTION_DELETE);
                            intent.setData(Uri.parse("package:" + packageName));
                            startActivity(intent);
                        }
                    }
                    break;
            }
        }
    };

    /**
     * 应用删除广播接收器
     */
    public class AppDelRecevice extends BroadcastReceiver {
        public static final String ACTION_APPDEL = "com.androidy.app.phone.del";

        @Override
        public void onReceive(Context context, Intent intent) {
            //TODO Auto-generated method stub
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_PACKAGE_REMOVED) || action.equals(ACTION_APPDEL)) {
                asynLoadApp();
            }
        }
    }
}