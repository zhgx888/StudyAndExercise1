package com.example.dialogs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SoftwareManagementActivitys extends AppCompatActivity {//软件管理类

    @Override


    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_software_managements);

    }



    @Override


    public boolean onCreateOptionsMenu(Menu menu) {
                    // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.softwaremanagementactivity_memus, menu);
      return true;
    }

    @Override


    public boolean onOptionsItemSelected(MenuItem item) {
                    // TODO Auto-generated method stub
        switch (item.getItemId()) {
             case R.id.menu_about:
             Toast.makeText(SoftwareManagementActivitys.this, "" + "关于", Toast.LENGTH_SHORT).show();
             break;
             case R.id.menu_settings:
                         Toast.makeText(SoftwareManagementActivitys.this, "" + "设置", Toast.LENGTH_SHORT).show();
             break;
            case R.id.menu_quit:

             Toast.makeText(SoftwareManagementActivitys.this, "" + "退出", Toast.LENGTH_SHORT).show();
            break;
            default:
            break;

        }
        //         Toast.makeText(MainActivity.this, ""+item.getItemId(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

}
