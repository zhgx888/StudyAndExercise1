package com.example.sqlitepractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public class MSqlHelper extends SQLiteOpenHelper {
    final String TAG = "MSqlHelper";

    public MSqlHelper(Context ctx) {
        super(ctx, MPersonDao.DATA_BASE_NAME, null, MPersonDao.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE persons(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR, " +
                "age INTEGER,info TEXT)");
        Log.i(TAG, "打开数据库");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "升级数据库" + newVersion);
    }
}
