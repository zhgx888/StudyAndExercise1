package com.example.contentprovidersdemo;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Administrator on 2017/1/4 0004.
 */

public class Constant implements BaseColumns {
    public static final String CONTENT_TYPE1 = "vnd.android.cursor.dir/demo";
    public static final String CONTENT_TYPE2 = "vnd.android.cursor.item/demo";
    public static final String  AUTHORITIES ="edu.feicui.androidsaveddemo";
    public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITIES+"/person");
    public static final Uri CONTENT_URI_ITEM = Uri.parse("content://"+AUTHORITIES+"/person/#");
    public static final String TABLE_NAME="persons";
    private static final String  DATABASE_NAME = "test.db";
    private static final int  DATABASE_VERSION= 1;

    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String INFO = "info";
}
