package com.example.phonebook;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/31 0031.
 */

public class PhoneBookListActivity extends AppCompatActivity {
    Context mCtx;
    int positionGrid = 1;
    PhoneBookDao phoneBD;
    ListView mLst;

    SQLiteDatabase sqlDB;
    List<Map<String, String>> lists=null;

    protected void onCreate(Bundle savedInstanceState) {
        mCtx = this;
        phoneBD = new PhoneBookDao(mCtx);
        super.onCreate(savedInstanceState);
        positionGrid = this.getIntent().getExtras().getInt("position");
        setContentView(R.layout.activity_phone_book_list);
        mLst = (ListView) findViewById(R.id.list_list);
        lists = phoneBD.readDirectorys(positionGrid);
        sqlDB = SQLiteDatabase.openOrCreateDatabase(mCtx.getFilesDir() + File.separator + "database" + File
                .separator + "commonnum.db", null);
        SimpleAdapter simAdp = new SimpleAdapter(this, lists, R.layout.activity_list, new String[]{"name",
                "number"}, new int[]{R.id.name, R.id.number});


        mLst.setAdapter(simAdp);
        mLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionList, long id) {
                Intent intent = new Intent();
                Uri uri=Uri.parse("tel:"+lists.get(positionList).get("number"));
                intent.setAction(intent.ACTION_CALL);//设置操作为打电话
                intent.setData(uri);//通过Uri设置电话号码
                startActivity(intent);

//                intent.setAction(intent.ACTION_DIAL);//设置操作为打电话
//                intent.setData(Uri.parse("tel:110"));//通过Uri设置电话号码;
//                startActivity(intent);
            }
        });

    }
}
