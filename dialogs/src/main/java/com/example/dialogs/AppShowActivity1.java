package com.example.dialogs;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

public class AppShowActivity1 extends AppCompatActivity {
    ListView mLst;
    ProgressBar mPrg;
    Context mCtx;
    List<PackageInfo> mAppInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = this;
        setContentView(R.layout.activity_app_show);
        mLst = (ListView) findViewById(R.id.soft_lst);
        mPrg = (ProgressBar) findViewById(R.id.soft_prg);
//        mLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                AppInfo appInfo = (AppInfo) parent.getItemAtPosition(position);
//
//            }
//        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                AppShow1 appShow1 = new AppShow1();
                mAppInfos = appShow1.getappInfos(mCtx);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mLst.setVisibility(View.VISIBLE);
                        mPrg.setVisibility(View.INVISIBLE);
                        mLst.setAdapter(new AppShowAdapter1(mCtx, mAppInfos));
                    }
                });
            }
        }).start();
    }
}
