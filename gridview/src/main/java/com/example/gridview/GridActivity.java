package com.example.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridActivity extends AppCompatActivity {
    GridView mGrdemo;
    int[] imageIds = new int[]{R.mipmap.bomb5, R.mipmap.bomb6, R.mipmap.bomb7, R.mipmap.bomb8, R.mipmap
            .bomb9, R.mipmap.bomb10, R.mipmap.bomb11, R.mipmap.bomb12, R.mipmap.bomb13, R.mipmap.bomb14, R
            .mipmap.bomb15, R.mipmap.bomb16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        mGrdemo = (GridView) findViewById(R.id.grid1);
        int[] to = new int[]{R.id.image1};//接收图片ID
        String[] from = {"image"};
        List<Map<String, Object>> lists = getAllData();//创建一个List对象，List对象的元素是Map
        SimpleAdapter adapter = new SimpleAdapter(this, lists, R.layout.item_grid_cell_layout, from, to);
        //创建一个SimpleAdapter
        mGrdemo.setAdapter(adapter);//为GridView设置Adapter
        mGrdemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "click" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<Map<String, Object>> getAllData() {
        List<Map<String, Object>> lists = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> list = new HashMap<String, Object>();
            list.put("image", imageIds[i]);
            lists.add(list);
        }
        return lists;
    }
}
