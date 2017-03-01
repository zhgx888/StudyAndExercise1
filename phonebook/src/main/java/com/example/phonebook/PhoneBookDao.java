package com.example.phonebook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/30 0030.
 */

public class PhoneBookDao {
    public static final String DATA_BASE_NAME = "dbtest";
    public static final int VERSION = 1;
    SQLiteDatabase sqlDB;
    Context mCtx;
    Cursor mCtxNums;

    PhoneBookDao(Context context) {
        mCtx = context;
    }

    public List<Map<String, String>> readDirectorys() {
        List<Map<String, String>> directorys = new ArrayList<>();
        sqlDB = SQLiteDatabase.openOrCreateDatabase(mCtx.getFilesDir() + File.separator + "database" + File
                .separator + "commonnum.db", null);
        Cursor cursor = sqlDB.rawQuery("select * from classlist;", null);
        while (cursor.moveToNext()) {
            Map<String, String> list = new HashMap<String, String>();
            String name = cursor.getString(0);
            list.put("name", name);
            directorys.add(list);
        }
        return directorys;
    }

    public List<Map<String, String>> readDirectorys(int position) {
        List<Map<String, String>> directorys = new ArrayList<>();
        sqlDB = SQLiteDatabase.openOrCreateDatabase(mCtx.getFilesDir() + File.separator + "database" + File
                .separator + "commonnum.db", null);
//        switch (position) {
//            case 0:
//                mCtxNums = sqlDB.rawQuery("select * from table1;", null);
//                break;
//            case 1:
//                mCtxNums = sqlDB.rawQuery("select * from table2;", null);
//                break;
//            case 2:
//                mCtxNums = sqlDB.rawQuery("select * from table3;", null);
//                break;
//            case 3:
//                mCtxNums = sqlDB.rawQuery("select * from table4;", null);
//                break;
//            case 4:
//                mCtxNums = sqlDB.rawQuery("select * from table5;", null);
//                break;
//            case 5:
//                mCtxNums = sqlDB.rawQuery("select * from table6;", null);
//                break;
//            case 6:
//                mCtxNums = sqlDB.rawQuery("select * from table7;", null);
//                break;
//            case 7:
//                mCtxNums = sqlDB.rawQuery("select * from table8;", null);
//                break;
//        }
        mCtxNums = sqlDB.rawQuery("select * from table"+(position+1)+";", null);

        while (mCtxNums.moveToNext()) {
            Map<String, String> list = new HashMap<String, String>();
            String number = mCtxNums.getString(1);
            String name = mCtxNums.getString(2);
            list.put("number", number);
            list.put("name", name);
            directorys.add(list);
        }
        return directorys;
    }
}