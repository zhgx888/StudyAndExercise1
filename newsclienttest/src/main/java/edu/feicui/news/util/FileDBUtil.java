package edu.feicui.news.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class FileDBUtil {
    MemoryUtil memoryUtil;

    /**
     * 读取数据
     */
    public Bitmap ReadImg(String url) {
        String path = Environment.getDataDirectory() + "/Icons/";
        Bitmap bitmap = null;
        File file = new File(path + url);
        if (file.exists()) {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            memoryUtil.setMemoryImg(url, bitmap);
        }
        return bitmap;
    }

    /**
     * 写入数据
     */
    public void wirteIcon(Bitmap bitmap, String url) {
        String path = Environment.getDataDirectory() + "/Icons/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File imgFile = new File(path + url);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(imgFile));//压缩图片
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
