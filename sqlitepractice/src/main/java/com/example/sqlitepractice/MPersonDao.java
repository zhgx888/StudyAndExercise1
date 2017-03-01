package com.example.sqlitepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public class MPersonDao {
    public static final String DATA_BASE_NAME = "dbtest";
    public static final int VERSION = 1;
    SQLiteDatabase db;
    MSqlHelper sqlHelper;


    public MPersonDao(Context ctx) {
        sqlHelper = new MSqlHelper(ctx);
    }

    public boolean addPerson(Person person) {
        boolean flag = false;
        db = sqlHelper.getWritableDatabase();
//        db.execSQL("insert into persons(name,age,info) values(?,?,?)",new Object[]{person.name,person
// .age,person.info});
        ContentValues cv = new ContentValues();
        cv.put("name", person.name);
        cv.put("age", person.age);
        cv.put("info", person.info);
        long row = db.insert("persons", null, cv);
        if (row >= 0) {
            flag = true;
        }
        closeDb();
        return flag;
    }

    public boolean delPerson(Person person) {
        boolean flag = false;
        db = sqlHelper.getWritableDatabase();
//        db.execSQL("delete from persons where name=?",new String []{person.name});
        int row = db.delete("persons", "name=?", new String[]{person.name});
        if (row >= 0) {
            flag = true;
        }
        closeDb();
        return flag;
    }

    public boolean updatePerson(Person person) {
        boolean flag = false;
        db = sqlHelper.getWritableDatabase();
//        db.execSQL("update persons set age=?,name=?where name=?",new Object[]{person.age,person.name,
// person.name});
        ContentValues cv = new ContentValues();
        cv.put("age", person.age);
        db.update("persons", cv, "name=?", new String[]{person.name});
        closeDb();
        return flag;
    }

    public List<Person> queryPersons(Person person) {
        List<Person> persons = new ArrayList<Person>();
        db = sqlHelper.getReadableDatabase();
//        db.execSQL("select _id,name,age,infofrom persons where _id<?",new Object[]{person.id});
//        Cursor cursor=db.rawQuery("select _id,name,age,info form persons where _id<?",new String[]{person
// .id});
        Cursor cursor = db.query("persons", new String[]{"_id", "name", "age", "info"}, "name=?", new
                String[]{person.name}, null, null, "age");
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String info = cursor.getString(3);
            Person p = new Person(name, id, age, info);
            persons.add(p);
        }
        closeDb();
        return persons;
    }
    public List<Person> queryAllPersons() {
        List<Person> persons = new ArrayList<Person>();
        db = sqlHelper.getReadableDatabase();
//        db.execSQL("select _id,name,age,infofrom persons where _id<?",new Object[]{person.id});
//        Cursor cursor=db.rawQuery("select _id,name,age,info form persons where _id<?",new String[]{person
// .id});
        Cursor cursor = db.query("persons", new String[]{"_id", "name", "age", "info"},null,null, null,null,null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String info = cursor.getString(3);
            Person p = new Person(name, id, age, info);
            persons.add(p);
        }
        closeDb();
        return persons;
    }
    public void closeDb() {
        db.close();
    }
}
