package com.example.dialogs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class SaveInstance {//单例类
    static Context mCtx;
    private static SaveInstance saveInstance;
    SharedPreferences sp = null;
    SharedPreferences.Editor et;

    private SaveInstance() {
        sp = mCtx.getSharedPreferences("test", Context.MODE_PRIVATE);
        et = sp.edit();
    }

    public synchronized static SaveInstance getSaveInstance(Context ctx) {
        mCtx = ctx;
        if (saveInstance == null) {
            return new SaveInstance();
        }
        return saveInstance;
    }

    public void putString(String key, String value) {
        et.putString(key, value);
        et.commit();
    }

    public void putBoolean(String key, boolean value) {
        et.putBoolean(key, value);
        et.commit();
    }

    public void putFloat(String key, float value) {
        et.putFloat(key, value);
        et.commit();
    }

    public void putLong(String key, Long value) {
        et.putLong(key, value);
        et.commit();
    }

    public void putInt(String key, int value) {
        et.putInt(key, value);
        et.commit();
    }

    public String getStringValue(String key) {
        return sp.getString(key, "unsaved");
    }

    public boolean getBooleanValue(String key) {
        return sp.getBoolean(key, false);
    }
}
