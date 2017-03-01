package edu.feicui.news.util;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class MBitmapUtil {
    MemoryUtil memoryUtil;
    FileDBUtil fileDBUtil;
    NetUtil netUtil;

    public MBitmapUtil() {
        memoryUtil = new MemoryUtil();
        fileDBUtil = new FileDBUtil();
        netUtil = new NetUtil();
    }

    public void display(ImageView view, String url) {
        Bitmap bitmap = null;
        bitmap = memoryUtil.getMemoryImg(url);
        if (bitmap != null) {
            view.setImageBitmap(bitmap);
            return;
        }
        bitmap = fileDBUtil.ReadImg(url);
        if (bitmap != null) {
            view.setImageBitmap(bitmap);
            return;
        }
        view.setTag(url);
        netUtil.downImg(view, url);
    }
}
