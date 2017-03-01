package com.example.dialogs;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7 0007.
 */

public class Memory {
    Context context;
    long blockSize;//块大小★
    long availableBlocks;//可用的块★
    long blockCount;//块总数★
    float separatePercentage;//已用占比
    ActivityManager activityManager;
    PackageManager packageManager;

    public Memory(Context context) {
        this.context = context;
        activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        packageManager = context.getPackageManager();
    }

    public void dataDirectory() {//手机存储空间
        File file = Environment.getDataDirectory();
        StatFs sfs = new StatFs(file.getAbsolutePath());
        sfs.getBlockSize();//获得块大小★
//        sfs.getBlockSizeLong();//获得块大小long类型
        sfs.getAvailableBlocks();//获得可用的块★
//        sfs.getAvailableBlocksLong();//获得可用的块long类型
//        sfs.getFreeBlocks();//获得免费的块
//        sfs.getFreeBlocksLong();//获得免费的块long类型
        sfs.getBlockCount();//获得块计数★
//        sfs.getBlockCountLong();//获得块计数long类型
//        sfs.getAvailableBytes();//获得可用的字节
//        sfs.getFreeBytes();//获得免费的字节
//        sfs.getTotalBytes();//获得总字节数
        blockSize = sfs.getBlockSize();
        availableBlocks = sfs.getAvailableBlocks();
        blockCount = sfs.getBlockCount();
    }

    //    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void rootDirectory() {//手机内存空间
        File file = Environment.getRootDirectory();
        StatFs sfs = new StatFs(file.getAbsolutePath());
        sfs.getBlockSize();//获得块大小★
//        sfs.getBlockSizeLong();//获得块大小long类型
        sfs.getAvailableBlocks();//获得可用的块★
//        sfs.getAvailableBlocksLong();//获得可用的块long类型
//        sfs.getFreeBlocks();//获得免费的块
//        sfs.getFreeBlocksLong();//获得免费的块long类型
        sfs.getBlockCount();//获得块计数★
//        sfs.getBlockCountLong();//获得块计数long类型
//        sfs.getAvailableBytes();//获得可用的字节
//        sfs.getFreeBytes();//获得免费的字节
//        sfs.getTotalBytes();//获得总字节数
        blockSize = sfs.getBlockSize();
        availableBlocks = sfs.getAvailableBlocks();
        blockCount = sfs.getBlockCount();

    }

    public void getExternalStorageDirectory() {//手机外存空间
        File file = Environment.getExternalStorageDirectory();
        StatFs sfs = new StatFs(file.getAbsolutePath());
        sfs.getBlockSize();//获得块大小★
//        sfs.getBlockSizeLong();//获得块大小long类型
        sfs.getAvailableBlocks();//获得可用的块★
//        sfs.getAvailableBlocksLong();//获得可用的块long类型
//        sfs.getFreeBlocks();//获得免费的块
//        sfs.getFreeBlocksLong();//获得免费的块long类型
        sfs.getBlockCount();//获得块计数★
//        sfs.getBlockCountLong();//获得块计数long类型
//        sfs.getAvailableBytes();//获得可用的字节
//        sfs.getFreeBytes();//获得免费的字节
//        sfs.getTotalBytes();//获得总字节数
        blockSize = sfs.getBlockSize();
        availableBlocks = sfs.getAvailableBlocks();
        blockCount = sfs.getBlockCount();
    }

    public long getPhoneAvailableRamMemory(Context context) {//
        MemoryInfo info = new MemoryInfo();//获得MemoryInfo
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.getMemoryInfo(info);
        return info.availMem;
    }

//        public long getPhoneTotalRamMemory(Context context) {//设备完整运行内存
//        ActivityManager.MemoryInfo info = new MemoryInfo();
//        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//        am.getMemoryInfo(info);
//        return info.totalMem;
//    }
    public long getPhobeTotalRamMemory() {//设备完整运行内存 单位B
        try {
            FileReader fr = new FileReader("/proc/meminfo");
            BufferedReader br = new BufferedReader(fr);
            String text = br.readLine();
            String[] array = text.split("\\s+");
            return Long.valueOf(array[1]) * 1024;//原来为KB，转换为b
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return 0;
    }

    public void killAllProcesses() {

        List<RunningAppProcessInfo> appProcessInfos = activityManager.getRunningAppProcesses();
        for (RunningAppProcessInfo appProcessInfo : appProcessInfos) {
            String packageName = appProcessInfo.processName;
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager
                        .GET_META_DATA | PackageManager.GET_SHARED_LIBRARY_FILES);
                //接前文|PackageManager.GET_UNINSTALLED_PACKAGES
                if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                } else {
                    activityManager.killBackgroundProcesses(packageName);
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public float separatePercentage() {//运行内存占比
        long availableMemory = getPhoneAvailableRamMemory(context);
        long totalMemory = getPhobeTotalRamMemory();
        long useMemory = totalMemory - availableMemory;
        float separatePercentages = ((float) useMemory / (float) totalMemory) * 100;
        DecimalFormat df = new DecimalFormat("#.00");
        separatePercentage = Float.parseFloat(df.format(separatePercentages));//已用占比
        Float angle = separatePercentage * 3.6f;//得到已用占比角度
        return angle;
    }

    public float dataAndExternalStoragePercentage() {//内外存占比
        dataDirectory();
        float dataBlockCountSize = blockSize * blockCount;
        getExternalStorageDirectory();
        float ESBlockCountSize = blockSize * blockCount;
        float separatePercentageAngles = dataBlockCountSize / (dataBlockCountSize + ESBlockCountSize) * 100
                * 3.6f;//得到内存占比角度
        DecimalFormat df = new DecimalFormat("0.00");
        float separatePercentageAngle = Float.parseFloat(df.format(separatePercentageAngles));
        return separatePercentageAngle;//返回内存占比角度
    }
}
