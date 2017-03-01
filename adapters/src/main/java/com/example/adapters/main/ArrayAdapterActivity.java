package com.example.adapters.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adapters.R;

import java.util.ArrayList;

/**
 * Created by jxf on 2016/12/21.
 */
public class ArrayAdapterActivity extends Activity {
    ListView listView;
    private ArrayList<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_adapter);
        listView = (ListView) findViewById(R.id.list_View);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_lv, R.id.textView1);
        for (int i = 0; i < 5; i++) {
            list.add("乌龟前进"+i+"米。");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}

