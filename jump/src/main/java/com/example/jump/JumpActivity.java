package com.example.jump;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class JumpActivity extends AppCompatActivity implements View.OnClickListener {
    Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9, mBtn10, mBtn11, mBtn12, mBtn13,
            mBtn14, mBtn15, mBtn16, mBtn17, mBtn18, mBtn19, mBtn20, mBtn21, mBtn22, mBtn23, mBtn24, mBtn25,
            mBtn26, mBtn27, mBtn28, mBtn29, mBtn30, mBtn31, mBtn32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        mBtn1 = (Button) findViewById(R.id.but_1);
        mBtn2 = (Button) findViewById(R.id.but_2);
        mBtn3 = (Button) findViewById(R.id.but_3);
        mBtn4 = (Button) findViewById(R.id.but_4);
        mBtn5 = (Button) findViewById(R.id.but_5);
        mBtn6 = (Button) findViewById(R.id.but_6);
        mBtn7 = (Button) findViewById(R.id.but_7);
        mBtn8 = (Button) findViewById(R.id.but_8);
        mBtn9 = (Button) findViewById(R.id.but_9);
        mBtn10 = (Button) findViewById(R.id.but_10);
        mBtn11 = (Button) findViewById(R.id.but_11);
        mBtn12 = (Button) findViewById(R.id.but_12);
        mBtn13 = (Button) findViewById(R.id.but_13);
        mBtn14 = (Button) findViewById(R.id.but_14);
        mBtn15 = (Button) findViewById(R.id.but_15);
        mBtn16 = (Button) findViewById(R.id.but_16);
        mBtn17 = (Button) findViewById(R.id.but_17);
        mBtn18 = (Button) findViewById(R.id.but_18);
        mBtn19 = (Button) findViewById(R.id.but_19);
        mBtn20 = (Button) findViewById(R.id.but_20);
        mBtn21 = (Button) findViewById(R.id.but_21);
        mBtn22 = (Button) findViewById(R.id.but_22);
        mBtn23 = (Button) findViewById(R.id.but_23);
        mBtn24 = (Button) findViewById(R.id.but_24);
        mBtn25 = (Button) findViewById(R.id.but_25);
        mBtn26 = (Button) findViewById(R.id.but_26);
        mBtn27 = (Button) findViewById(R.id.but_27);
        mBtn28 = (Button) findViewById(R.id.but_28);
        mBtn29 = (Button) findViewById(R.id.but_29);
        mBtn30 = (Button) findViewById(R.id.but_30);
        mBtn31 = (Button) findViewById(R.id.but_31);
        mBtn32 = (Button) findViewById(R.id.but_32);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);
        mBtn9.setOnClickListener(this);
        mBtn10.setOnClickListener(this);
        mBtn11.setOnClickListener(this);
        mBtn12.setOnClickListener(this);
        mBtn13.setOnClickListener(this);
        mBtn14.setOnClickListener(this);
        mBtn15.setOnClickListener(this);
        mBtn16.setOnClickListener(this);
        mBtn17.setOnClickListener(this);
        mBtn18.setOnClickListener(this);
        mBtn19.setOnClickListener(this);
        mBtn20.setOnClickListener(this);
        mBtn21.setOnClickListener(this);
        mBtn22.setOnClickListener(this);
        mBtn23.setOnClickListener(this);
        mBtn24.setOnClickListener(this);
        mBtn25.setOnClickListener(this);
        mBtn26.setOnClickListener(this);
        mBtn27.setOnClickListener(this);
        mBtn28.setOnClickListener(this);
        mBtn29.setOnClickListener(this);
        mBtn30.setOnClickListener(this);
        mBtn31.setOnClickListener(this);
        mBtn32.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.but_1:
                intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_2:
                intent = new Intent(Settings.ACTION_ADD_ACCOUNT);
                startActivity(intent);
                break;
            case R.id.but_3:
                intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_4:
                intent = new Intent(Settings.ACTION_APN_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_5:
                Uri packageURI = Uri.parse("package:" + "com.tencent.WBlog");
                intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                startActivity(intent);
                break;
            case R.id.but_6:
                intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_7:
                intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_8:
                intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_9:
                intent = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_10:
                intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_11:
                intent = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_12:
                intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_13:
                intent = new Intent(Settings.ACTION_DREAM_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_14:
                intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_15:
                intent = new Intent(Settings.ACTION_INPUT_METHOD_SUBTYPE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_16:
                intent = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_17:
                intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_18:
                intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_19:
                intent = new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_20:
                intent = new Intent(Settings.ACTION_NFCSHARING_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_21:
                intent = new Intent(Settings.ACTION_NFC_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_22:
                intent = new Intent(Settings.ACTION_PRIVACY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_23:
                intent = new Intent(Settings.ACTION_QUICK_LAUNCH_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_24:
                intent = new Intent(Settings.ACTION_SEARCH_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_25:
                intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_26:
                intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_27:
                intent = new Intent(Settings.ACTION_SOUND_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_28:
                intent = new Intent(Settings.ACTION_SOUND_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_29:
                intent = new Intent(Settings.ACTION_USER_DICTIONARY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_30:
                intent = new Intent(Settings.ACTION_WIFI_IP_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_31:
                intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;
            case R.id.but_32:
                intent = getPackageManager().getLaunchIntentForPackage("com.example.dialogs");
                startActivity(intent);
                break;
        }
    }
}
