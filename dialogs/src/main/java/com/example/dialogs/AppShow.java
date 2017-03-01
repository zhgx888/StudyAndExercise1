package com.example.dialogs;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7 0007.
 */

public class AppShow {
    private ArrayList<AppInfo> appInfos;
    private AppInfo appInfo;
    public ArrayList<AppInfo> getappInfos(Context context) {
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> pakageinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        appInfos = new ArrayList<AppInfo>();
        for (PackageInfo packageInfo : pakageinfos) {
            appInfo = new AppInfo();
            appInfo.packageInfo=packageInfo;
            appInfos.add(appInfo);
        }
        return appInfos;
    }
}
