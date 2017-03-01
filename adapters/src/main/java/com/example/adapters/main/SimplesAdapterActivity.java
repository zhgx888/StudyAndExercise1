package com.example.adapters.main;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.adapters.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplesAdapterActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_adapter);
        listView = (ListView) findViewById(R.id.list_View);
        String[] from = {"name", "age"};
        int[] to = {android.R.id.text1, android.R.id.text2 };
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 6; i++) {
            Map<String, String> map = new HashMap<String, String>();
            if (i % 3 == 0) {
                map.put("name", "小明");
                map.put("age", "12");
            } else if (i % 3 == 1) {
                map.put("name", "小强");
                map.put("age", "11");
            } else {
                map.put("name", "小红");
                map.put("age", "12");
            }
            data.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(SimplesAdapterActivity.this, data, android.R.layout.simple_list_item_2,from,to);
        listView.setAdapter(adapter);
    }
}