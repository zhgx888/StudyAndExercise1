package com.example.sqlitepractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SQLitePracticeActivity extends AppCompatActivity {
private  static final  java.lang.String TAG ="SQLHelpActivity##";
    Button mBtnAdd,mBtnDel,mBtnUpdate,mBtnQuery,mBtnQueryAll;
    MPersonDao manager;
    TextView mTxtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_practice);
        mBtnAdd= (Button) findViewById(R.id.btn_add);
        mBtnDel= (Button) findViewById(R.id.btn_del);
        mBtnUpdate= (Button) findViewById(R.id.btn_update);
        mBtnQuery= (Button) findViewById(R.id.btn_query);
        mBtnQueryAll= (Button) findViewById(R.id.btn_queryall);
        mTxtContent= (TextView) findViewById(R.id.mTxtContent);
        manager=new MPersonDao(SQLitePracticeActivity.this);
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person>persons=query();
                mTxtContent.setText(persons.toString());
            }
        });
        mBtnQueryAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person>persons=queryAll();
                mTxtContent.setText(persons.toString());
            }
        });
    }

    void add(View view) {
        manager.addPerson(new Person("小明",20,"男"));
        manager.addPerson(new Person("小红",30,"女"));
        manager.addPerson(new Person("小花",40,"女"));
    }
    void del (View v) {
//        manager.delPerson(new Person("小明", 20, "男"));
        manager.delPerson(new Person("小红",2,"女"));
//        manager.delPerson(new Person("小花",40,"女"));
    }

    void update(View view) {
        manager.updatePerson(new Person("小红",2,"女"));
    }

    List<Person> query() {
        List<Person>ps = manager.queryPersons(new Person("小花",40,"女"));
        if (ps!=null){
            for (int i=0;i<ps.size();i++) {
                String info =ps.get(i).info;
                Log.i(TAG,info);
            }
        }
        return ps;
    }
    List<Person> queryAll() {
        List<Person>ps = manager.queryAllPersons();
        if (ps!=null){
            for (int i=0;i<ps.size();i++) {
                String name =ps.get(i).name;
                Log.i(TAG,name);
            }
        }
        return ps;
    }
}
