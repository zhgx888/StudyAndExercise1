package com.example.dialogs;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by Administrator on 2017/1/5 0005.
 */

public class DialogUtils {
    static Context mCxt;

    public static void alertDialog(Context ctx, DialogInterface.OnClickListener okListener, DialogInterface
            .OnClickListener cancelListener) {
        mCxt = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("这是一个警示提示框")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("确定", okListener)
                .setNegativeButton("取消", cancelListener)
                .show();
    }

    public static void alertDialog(Context ctx, DialogInterface.OnClickListener loveListener,
                                   DialogInterface.OnClickListener hateListener, DialogInterface
                                           .OnClickListener sosoListener) {
        mCxt = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("这是一个三按钮对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("喜欢", loveListener)
                .setNegativeButton("不喜欢", hateListener)
                .setNeutralButton("一般", sosoListener)
                .show();
    }

    public static void alertDialog(Context ctx, View view, DialogInterface.OnClickListener loveListener,
                                   DialogInterface.OnClickListener hateListener) {
        mCxt = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("这是一个简单的View对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("喜欢", loveListener)
                .setNegativeButton("不喜欢", hateListener)
                .setView(view)
                .show();
    }

    public static void sigleAlertDialog(Context ctx, String[] items, int checked, DialogInterface
            .OnClickListener okListener, DialogInterface.OnClickListener choiceListrner) {
        mCxt = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("这是一组单选对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("ok", okListener)
                .setSingleChoiceItems(items, checked, choiceListrner)
                .show();
    }

    public static void multiAlertDialog(Context ctx, String[] items, boolean[] checked, DialogInterface
            .OnClickListener okListener, DialogInterface.OnMultiChoiceClickListener mcListener) {
        mCxt = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("这是一组多选对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("ok", okListener)
                .setMultiChoiceItems(items, checked, mcListener)
                .show();
    }

    public static AlertDialog itemsAlertDialog(Context ctx, String[] items, DialogInterface.OnClickListener
            choiceClickListener) {
        mCxt = ctx;
        AlertDialog dialog = new AlertDialog.Builder(ctx)
                .setTitle("这是一组警示对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(items, choiceClickListener).create();
        dialog.show();
        return dialog;
    }

    public static ProgressDialog progressDialog(Context ctx) {
        mCxt = ctx;
        ProgressDialog progressDialog = new ProgressDialog(ctx);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setTitle("请等待");
        progressDialog.setMessage("正在加载……");
        progressDialog.show();
        return progressDialog;
    }

    public static void customAlertDialog(Context ctx, View view, DialogInterface.OnClickListener
            loveListener, DialogInterface.OnClickListener hateListener) {
        mCxt = ctx;
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setPositiveButton("喜欢", loveListener)
                .setNegativeButton("不喜欢", hateListener)
                .setView(view)
                .show();
    }
}
