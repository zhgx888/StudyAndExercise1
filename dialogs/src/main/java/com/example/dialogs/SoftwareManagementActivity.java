package com.example.dialogs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SoftwareManagementActivity extends AppCompatActivity {//软件管理类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_management);
        Toolbar tbar= (Toolbar) findViewById(R.id.tool_bar);
        tbar.setTitle("");
        setSupportActionBar(tbar);
        tbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoftwareManagementActivity.this,"fanhui",Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.softwaremanagementactivity_memu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Toast.makeText(SoftwareManagementActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_back:
                Toast.makeText(SoftwareManagementActivity.this,"返回成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_desc:
                Toast.makeText(SoftwareManagementActivity.this,"确认成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_delete:
                Toast.makeText(SoftwareManagementActivity.this,"清除成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.group:
                Toast.makeText(SoftwareManagementActivity.this,"团队",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
