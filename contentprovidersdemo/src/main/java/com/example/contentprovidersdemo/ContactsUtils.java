package com.example.contentprovidersdemo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/4 0004.
 */

public class ContactsUtils extends ContentProvider {
    MSqlHelper dbHelper;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final String TAG = "MContentProvider";
    private static final int PERSON = 1;
    private static final int PERSON_ITEM = 2;
    private SQLiteDatabase sqlDB;

    static {
        sUriMatcher.addURI(Constant.AUTHORITIES, "person", PERSON);
        sUriMatcher.addURI(Constant.AUTHORITIES, "person/#", PERSON_ITEM);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new MSqlHelper(getContext());
        return (dbHelper == null ? false : true);
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String
            sortOrder) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(Constant.TABLE_NAME);
        Cursor cursor = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
//        Cursor cursor=db.query(Constant.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case PERSON:
                return Constant.CONTENT_TYPE1;
            case PERSON_ITEM:
                return Constant.CONTENT_TYPE2;
            default:
                throw new IllegalArgumentException("Unknown URI" + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        sqlDB = dbHelper.getWritableDatabase();
        long rowId = sqlDB.insert(Constant.TABLE_NAME, null, values);
        Log.i("db###", "rowID" + rowId);
        if (rowId >= 0) {
            Uri rowUri = ContentUris.appendId(Constant.CONTENT_URI.buildUpon(), rowId).build();
            getContext().getContentResolver().notifyChange(rowUri, null);
            return rowUri;
        }
        throw new SQLException("插入行失败" + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.i("delete:", uri.getPath());
        int action = sUriMatcher.match(uri);
        Log.i("delete", action + "");
        switch (action) {
            case 2://匹配单条记录
                String name = uri.getLastPathSegment();
                Log.i("delete##", name);
                String delete_id = "name=" + "'" + name + "'";//获取单条记录的id号
                Log.i("delete##", delete_id);
                if (selection != null) {
                    delete_id += delete_id + "and" + selection;
                }
                db.delete(Constant.TABLE_NAME,delete_id,selectionArgs);
                break;
            case PERSON:
                db.delete(Constant.TABLE_NAME,null,null);
                break;
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count=-1;
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        int action=sUriMatcher.match(uri);
        switch (action) {
            case 2:long id=ContentUris.parseId(uri);
                String id_selection="_id="+id;
                if (selection != null && !selection.equals("")) {
                    id_selection = id_selection + "and" + values;
                }
                count=db.update("student",values,id_selection,selectionArgs);
                System.out.println("----------count:"+count);
                break;
        }
        return count;
    }
}
