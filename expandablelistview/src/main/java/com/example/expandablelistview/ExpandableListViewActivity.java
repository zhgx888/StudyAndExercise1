package com.example.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandableListViewActivity extends AppCompatActivity {
    //    声明一个可伸展的列表视图对象
    ExpandableListView expandlist;
    //    声明并初始化一个组集合对象，该集合时一个一维数组
    List<Map<String, Object>> groupList = new ArrayList<Map<String, Object>>();
    //    声明一个可伸展的列表视图对象个子元素集合对象，该集合是一个表
    List<List<Map<String, Object>>> childList = new ArrayList<List<Map<String, Object>>>();
    //    声明一个子元素集合对象
    List<Map<String, Object>> child;
    //    声明一个map对象
    Map<String, Object> map;
    //    组元素值
    String[] armTypes = new String[]{"WORD", "EXCEL", "EMAIL", "PPT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandablelistview);//加载布局
        for (int i=0;i<armTypes.length;i++){//给组赋值
            map=new HashMap<String,Object>();//每次都要初始化map对象
            map.put("Group",armTypes[i]);//将组值放入key为Group的map中
            groupList.add(map);//将map添加到集合中
        }
        for(int  j=0;j<4;j++){//给每组的子元素赋值
            child=new ArrayList<Map<String,Object>>(); //每次初始化子集合对象。该对象是一个一维数组
            for(int k=0;k<25;k++){//每个组下面有25个子元素
                map=new HashMap<String, Object>();//初始化map对象
                map.put("Child","this is"+k+"example");//将子元素的值放入key值为Child的map中
                child.add(map);//将map添加到一维数组中
            }
            childList.add(child);//将一维数组添加到集合中
        }
        expandlist= (ExpandableListView) findViewById(R.id.expandlst);//可伸展的列表视图绑定ID
//        MyExpandableListAdapter adapter=new MyExpandableListAdapter();//声明并初始化一个adapter
//        expandlist.setAdapter(adapter);//可伸展的列表视图加载adapter
    }
}