package com.example.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner= (Spinner) findViewById(R.id.spinner);
        String[]arr={"唐僧","孙悟空","猪八戒","沙悟净"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arr);//创建ArrayAdapter对象
        spinner.setPopupBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        spinner.setAdapter(adapter);//为Spinner设置Adapter
    }
}
