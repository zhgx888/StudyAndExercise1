package com.example.phonebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class PhoneBookActivity extends AppCompatActivity {
    Context mCtx;
    GridView mGrd;
    PhoneBookDao phoneBD;
    PhoneBookInAndOut phoneBIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mCtx = this;
        phoneBD = new PhoneBookDao(mCtx);
        phoneBIO = new PhoneBookInAndOut(mCtx);
        phoneBIO.PhoneBookRW();
        setContentView(R.layout.activity_phone_book);
        mGrd = (GridView) findViewById(R.id.gv_list);
        List<Map<String, String>> lists = phoneBD.readDirectorys();
        SimpleAdapter simAdp = new SimpleAdapter(this, lists, R.layout.activity_grid, new String[]{"name"},
                new int[]{R.id.txt_butimg});
        mGrd.setAdapter(simAdp);
        mGrd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PhoneBookActivity.this, PhoneBookListActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
