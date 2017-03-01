package com.example.contentprovidersdemo;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ContentProvidersDemoActivity extends AppCompatActivity {
    TextView mTxtUserInfo;
    MenuItem mMenAdd;
    MenuItem mMenExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_providers_demo);
        mTxtUserInfo = (TextView) findViewById(R.id.mTxtUserInfo);
        mMenAdd = (MenuItem) findViewById(R.id.item_add);
        mMenExit = (MenuItem) findViewById(R.id.item_exit);
        String result = getContactInfo();
        mTxtUserInfo.setTextColor(Color.BLUE);
        mTxtUserInfo.setText("记录\t名字\t电话\n" + result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                addContact();
                String result = getContactInfo();
                mTxtUserInfo.setTextColor(Color.BLUE);
                mTxtUserInfo.setText("记录\t名字\t电话\n" + result);
                break;
            case R.id.item_exit:
                ContentProvidersDemoActivity.this.finish();
        }
        return true;
    }

    public String getContactInfo() {
        String result = "";
        ContentResolver resolove = getContentResolver();
//        Phone.CONTENT_URI;//查询联系人
        Cursor cursor = resolove.query(Contacts.CONTENT_URI, null, null, null, null);
        int idIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
        //取得联系人名字（显示出来的名字），实际内容在ContactsContract.Contacts中
        int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        for (cursor.moveToFirst(); (!cursor.isAfterLast()); cursor.moveToNext()) {
            //获取联系人id
            String contactId = cursor.getString(idIndex);
            result = result + contactId + "\t\t\t";
            result = result + cursor.getString(nameIndex) + "\t\t\t";
            //根据联系人ID查询对应的电话号码
            Cursor phoneNumbers = resolove.query(Phone.CONTENT_URI, null, Email.CONTACT_ID + "="
                    + contactId, null, null);
            //取得电话号码（可能存在多个号码）
            while (phoneNumbers.moveToNext()) {
                String strPhoeneNumber = phoneNumbers.getString(phoneNumbers.getColumnIndex(Phone.NUMBER));
                result = result + strPhoeneNumber + "\t\t\t\t";
            }
            phoneNumbers.close();
            //根据联系人ID查询对应的email
            Cursor emails = resolove.query(Email.CONTENT_URI, null, Email.CONTACT_ID + "=" + contactId,
                    null, null);
            //取得email（可能存在多个email）
            while (emails.moveToNext()) {
                String strEmail = emails.getString(emails.getColumnIndex(Email.DATA));
                result = result + strEmail + "\t\t\t";
            }
            emails.close();
            result = result + "\n";
        }
        cursor.close();
        return result;
    }

    private void addContact() {//添加一个通讯录
        //创建一个空的ContentValues
        ContentValues values = new ContentValues();
        //向awContacts.CONTENT_URI执行一个空值插入，
        //目的是获取系统返回的rawContactId
        Uri rawContactUri = getContentResolver().insert(RawContacts.CONTENT_URI, values);
        long rawContactId = ContentUris.parseId(rawContactUri);
        values.clear();
        /*添加人名*/
        values.put(Data.RAW_CONTACT_ID, rawContactId);
        //设置内容类型
        values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        //设置联系人名字
        values.put(StructuredName.GIVEN_NAME, "约翰");
        //向联系人URI添加联系人名字
        getContentResolver().insert(Data.CONTENT_URI, values);
        values.clear();
        /*添加号码*/
        values.put(Data.RAW_CONTACT_ID, rawContactId);
        values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        //设置联系热的Email地址
        values.put(Email.DATA, "cc@qq.com");
        //设置该电子邮件的类型
        values.put(Email.TYPE, Email.TYPE_HOME);
        //向联系人Email URI添加Email数据
        getContentResolver().insert(Data.CONTENT_URI, values);
        Toast.makeText(ContentProvidersDemoActivity.this, "联系人数据添加成功", Toast.LENGTH_SHORT).show();
    }
}