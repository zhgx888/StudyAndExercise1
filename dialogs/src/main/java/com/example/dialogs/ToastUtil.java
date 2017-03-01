package com.example.dialogs;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/5 0005.
 */

public class ToastUtil {
    private static Toast toast;

    public static void show(Context context, String text, int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, text, duration);
        } else {
            toast.setText(text);
            toast.setDuration(duration);
        }
        toast.show();
    }
}
