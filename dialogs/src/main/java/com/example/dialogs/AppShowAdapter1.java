package com.example.dialogs;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/7 0007.
 */

public class AppShowAdapter1 extends BaseAdapter {
    Context mCtx;
    List<PackageInfo> mAppInfos;
    PackageManager pm;
    public AppShowAdapter1(Context mCtx, List<PackageInfo> mAppInfos) {
        this.mCtx = mCtx;
        this.mAppInfos = mAppInfos;
        pm = mCtx.getPackageManager();

    }

    @Override
    public int getCount() {
        return mAppInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mAppInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        1.复用view优化listview,创建一个view作为getview的返回值用来显示一个条目
        View view = convertView;
        ViewHolder viewHolder = new ViewHolder();
        /**
         * 防止运行时会来回滚动一直生成新布局占用内存
         */
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mCtx.getSystemService(Context
                    .LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.appshow_style, null);
            //        2.获取view上的子控件对象
            viewHolder.mImgIcon = (ImageView) view.findViewById(R.id.img_icon);
            viewHolder.mTxtName = (TextView) view.findViewById(R.id.txt_name);
            viewHolder.mTxtVersion = (TextView) view.findViewById(R.id.txt_version);
            viewHolder.mTxtInfo = (TextView) view.findViewById(R.id.txt_info);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
//        3.获取postion位置条目对应的list集合中的数据，Bean对象
        PackageInfo appInfo = mAppInfos.get(position);
//        4.将数据设置给这些子控件做显示
        viewHolder.mImgIcon.setImageDrawable(appInfo.applicationInfo.loadIcon(pm));
        viewHolder.mTxtName.setText(appInfo.applicationInfo.loadLabel(pm).toString());
        viewHolder.mTxtVersion.setText(appInfo.versionName);
        viewHolder.mTxtInfo.setText(appInfo.applicationInfo.packageName);
        return view;
    }
    public void deletedApp(){

    }

    class ViewHolder {
        public ImageView mImgIcon;
        public TextView mTxtName;
        public TextView mTxtVersion;
        public TextView mTxtInfo;
    }
}
