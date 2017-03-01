package com.example.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.text.DecimalFormat;
/**
 * Created by Administrator on 2017/1/9 0009.
 */


public class ExternalStorageDirectoryCountUtils extends Activity{
    private TextView tv;//用来显示存储卡的情况
    private Button b;//触发检测存储卡事件
    private ProgressBar pb;//用ProgressBar来显示存储卡的状况
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage_directory_count_utils);
        tv=(TextView)findViewById(R.id.tv);
        b=(Button)findViewById(R.id.button);
        pb=(ProgressBar)findViewById(R.id.pb);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showSize();//用来检测存储卡的存储情况
            }

        });
    }
    protected void showSize() {
        // TODO Auto-generated method stub
        tv.setText("");
        pb.setProgress(0);
        //用来检测存储卡是否存在
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            //如果存储卡存在，则获取存储文件的路径
            File path=Environment.getExternalStorageDirectory();
            StatFs sf=new StatFs(path.getPath());//创建StatFs对象
            long blockSize=sf.getBlockSize();//获得blockSize
            long totalBlock=sf.getBlockCount();//获得全部block
            long availableBlock=sf.getAvailableBlocks();//获取可用的block
            //用String数组来存放Block信息
            String[] total=fileSize(totalBlock*blockSize);
            String[] available=fileSize(availableBlock*blockSize);
            //在ProgressBar中显示可用空间的大小
            int a=Integer.parseInt(available[0]);
            pb.setProgress(a);
            String s="SD卡中空间总共有："+total[0]+total[1]+"\n";
            s+="剩余空间大小："+available[0]+available[1];
            tv.setText(s);
        }
        else if(Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)){
            tv.setText("SD卡已移除");
        }
    }
    //用来定义存储空间显示格式
    public String[] fileSize(long size){
        String s="";
        if(size>1024){
            s="KB";
            size/=1024;
            if(size>1024){
                s="M";
                size/=1024;
                if (size > 1024) {
                    s="G";
                    size/=1024;
                }
            }
        }
        DecimalFormat df=new DecimalFormat();
//        df.setGroupingSize(3);
        String[] result=new String[3];
        result[0]=df.format(size);
        result[1]=s;
        return result;
    }
}

