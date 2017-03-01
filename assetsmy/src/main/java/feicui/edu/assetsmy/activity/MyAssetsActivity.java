package feicui.edu.assetsmy.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import feicui.edu.assetsmy.R;
import feicui.edu.assetsmy.entity.SmsBean;

public class MyAssetsActivity extends AppCompatActivity{
    ListView mLstAss;
    Context mCtx;
    ArrayList<SmsBean> mSmsbeans;
    Button mBtnInput;
    Button mBtnOutput;
    TextView mTxtWrite;
    MyAssetsParsing myAssPas;
    ExternalStorageUtils esu;
    SaveInstance saveInstance;
    CheckBox mCkbSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCtx = this;
        setContentView(R.layout.activity_my_assets);
        myAssPas = new MyAssetsParsing(mCtx);
        mLstAss = (ListView) findViewById(R.id.List_view);
        mSmsbeans = (ArrayList<SmsBean>) myAssPas.readList();
        mBtnInput = (Button) findViewById(R.id.btn_input);
        mBtnOutput = (Button) findViewById(R.id.btn_output);
        mCkbSave= (CheckBox) findViewById(R.id.checkBox);
        mTxtWrite= (TextView) findViewById(R.id.tv_write);
        saveInstance=SaveInstance.getSaveInstance(mCtx);
        String isSaved=saveInstance.getStringValue("isSaved");
        if("saved".equals(isSaved)){
            mCkbSave.setChecked(true);
        }else{
            mCkbSave.setChecked(false);
        }
        mCkbSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    saveInstance.putString("isSaved","saved");
                }else{
                    saveInstance.putString("isSaved","unsaved");
                }
            }
        });
        mBtnInput.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mLstAss.setAdapter(new CustomAdapter());
            }
        });

        ExternalStorageUtils.writeFileFromExtranlStorage();
        String str=ExternalStorageUtils.readFileFromExteranlStorage();
        mTxtWrite.setText(esu.sb);
        Toast.makeText(MyAssetsActivity.this,str,Toast.LENGTH_LONG).show();
    }

    class CustomAdapter extends BaseAdapter {
        //       Map<Integer, String> map = new HashMap<Integer, String>();
        @Override
        public int getCount() {
            return mSmsbeans.size();
        }

        @Override
        public Object getItem(int position) {
            return mSmsbeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(R.layout.activity_my_assets_style, null);
            }
            TextView sbNum = (TextView) v.findViewById(R.id.num);
            TextView sbTimes = (TextView) v.findViewById(R.id.times);
            TextView sbContent = (TextView) v.findViewById(R.id.content);
            SmsBean smsBean = mSmsbeans.get(position);
            sbNum.setText(smsBean.num);
            sbTimes.setText(smsBean.times);
            sbContent.setText(smsBean.content);
            return v;
        }
    }
}