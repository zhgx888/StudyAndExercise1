package com.example.adapters.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.adapters.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSimpleAdapterActivity extends AppCompatActivity {
    TextView mTxtSimp;
    ListView listView;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customsimple_adapter);
//        mTxtSimp = (TextView) findViewById(R.id.name);
//        mTxtSimp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = getIntent();
////                Bundle bundle = new Bundle();
////                bundle.putString("ok", "yes");
////                intent.putExtras(bundle);
////                setResult(RESULT_OK, intent);//intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
////                finish();//此处一定要调用finish()方法
//            }
//        });
        listView = (ListView) findViewById(R.id.listView);
        String[] from = {"name", "sex", "age"};
        int[] to = {R.id.name, R.id.sex, R.id.age};
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 9; i++) {
            Map<String, String> map = new HashMap<String, String>();
            if (i % 3 == 0) {
                map.put("name", "小明");
                map.put("sex", "男");
                map.put("age", "12岁");
            } else if (i % 3 == 1) {
                map.put("name", "小强");
                map.put("sex", "男");
                map.put("age", "11岁");
            } else {
                map.put("name", "小红");
                map.put("sex", "女");
                map.put("age", "12岁");
            }
            data.add(map);
        }
        adapter = new SimpleAdapter(CustomSimpleAdapterActivity.this, data, R.layout.activity_customsimple_adapter, from, to);
        listView.setAdapter(adapter);
    }
}

