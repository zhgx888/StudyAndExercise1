package com.example.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogDemoActivity extends AppCompatActivity implements View.OnClickListener {
    Button mBtnAPD, mBtnTBD, mBtnVD, mBtnSCD, mBtnMCD, mBtnLD, mBtnCL, mBtnDV1, mBtnDV2, mBtnTbMn1,
            mBtnTbMn2, mBtnESDC, mBtnWeb,mBtnPag,mBtnMusic,mBtnAppShow,mBtnAppShow1;
    String[] strs = {"aaa", "bbb", "ccc", "ddd"};
    boolean[] checked = {true, false, false, false};
    StringBuilder builder1 = new StringBuilder();
    AlertDialog dialog;
    int number = -1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_dem);
        mBtnAPD = (Button) findViewById(R.id.arningPromptDialog);
        mBtnTBD = (Button) findViewById(R.id.threeButtonDialog);
        mBtnVD = (Button) findViewById(R.id.viewDialog);
        mBtnSCD = (Button) findViewById(R.id.singleChoiceDialog);
        mBtnMCD = (Button) findViewById(R.id.multipleChoiceDialog);
        mBtnLD = (Button) findViewById(R.id.listDialog);
        mBtnCL = (Button) findViewById(R.id.customLayout);
        mBtnDV1 = (Button) findViewById(R.id.drawView1);
        mBtnDV2 = (Button) findViewById(R.id.drawView2);
        mBtnTbMn1 = (Button) findViewById(R.id.toolbar_mune);
        mBtnTbMn2 = (Button) findViewById(R.id.toolbar_mune2);
        mBtnESDC = (Button) findViewById(R.id.toolbar_ESDCount);
        mBtnWeb = (Button) findViewById(R.id.btn_Web);
        mBtnPag = (Button) findViewById(R.id.btn_Pager);
        mBtnMusic = (Button) findViewById(R.id.btn_mediaPlay);
        mBtnAppShow = (Button) findViewById(R.id.btn_AppShow);
        mBtnAppShow1 = (Button) findViewById(R.id.btn_AppShow1);
        mBtnAPD.setOnClickListener(this);
        mBtnTBD.setOnClickListener(this);
        mBtnVD.setOnClickListener(this);
        mBtnSCD.setOnClickListener(this);
        mBtnMCD.setOnClickListener(this);
        mBtnLD.setOnClickListener(this);
        mBtnCL.setOnClickListener(this);
        mBtnDV1.setOnClickListener(this);
        mBtnDV2.setOnClickListener(this);
        mBtnTbMn1.setOnClickListener(this);
        mBtnTbMn2.setOnClickListener(this);
        mBtnESDC.setOnClickListener(this);
        mBtnWeb.setOnClickListener(this);
        mBtnPag.setOnClickListener(this);
        mBtnMusic.setOnClickListener(this);
        mBtnAppShow.setOnClickListener(this);
        mBtnAppShow1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (v.getId()) {
            case R.id.arningPromptDialog://2个按钮对话框
                DialogUtils.alertDialog(DialogDemoActivity.this, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(DialogDemoActivity.this, which + "", Toast.LENGTH_LONG);
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(DialogDemoActivity.this, which + "", Toast.LENGTH_LONG);
                    }
                });
                break;
            case R.id.threeButtonDialog://3个按钮对话框
                DialogUtils.alertDialog(DialogDemoActivity.this, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(DialogDemoActivity.this, which + "", Toast.LENGTH_LONG);
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(DialogDemoActivity.this, which + "", Toast.LENGTH_LONG);
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(DialogDemoActivity.this, which + "", Toast.LENGTH_LONG);
                    }
                });
                break;
            case R.id.viewDialog://viewd对话框
                DialogUtils.alertDialog(DialogDemoActivity.this, new EditText(DialogDemoActivity.this),
                        null, null);
                break;
            case R.id.singleChoiceDialog://单选对话框
                DialogUtils.sigleAlertDialog(DialogDemoActivity.this, strs, number, new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        ToastUtil.show(DialogDemoActivity.this,builder1.toString(), Toast.LENGTH_LONG);
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        number = which;
//                        ToastUtil.show(DialogDemoActivity.this,builder1.toString(), Toast.LENGTH_LONG);
//                            builder1.append(strs[which]);
                    }
                });
                break;
            case R.id.multipleChoiceDialog://多选对话框
                DialogUtils.multiAlertDialog(DialogDemoActivity.this, strs, checked, new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(DialogDemoActivity.this, builder1.toString(), Toast.LENGTH_LONG);
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            builder1.append(strs[which]);
                        } else {

                        }
                    }
                });
                break;
            case R.id.listDialog://列表对话框
                dialog = DialogUtils.itemsAlertDialog(DialogDemoActivity.this, strs, new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(DialogDemoActivity.this, which + "", Toast.LENGTH_LONG);
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.customLayout:
                DialogUtils.progressDialog(DialogDemoActivity.this);
//                DialogUtils.customAlertDialog(DialogDemoActivity.this, LayoutInflater.from
//                        (DialogDemoActivity.this).inflate(R.layout.activity_dialog_dem, null), new
//                                DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(DialogDemoActivity.this, "cancel", Toast
//                                                .LENGTH_LONG).show();
//                                    }
//                                }, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(DialogDemoActivity.this, "soso", Toast.LENGTH_LONG).show();
//                            }
//                        });
                break;
            case R.id.drawView1:
                startActivity(new Intent(DialogDemoActivity.this, MCustomViewActivity.class));
                break;
            case R.id.drawView2:
                startActivity(new Intent(DialogDemoActivity.this, MCustomViewActivitys.class));
                break;
            case R.id.toolbar_mune:
                startActivity(new Intent(DialogDemoActivity.this, SoftwareManagementActivity.class));
                break;
            case R.id.toolbar_mune2:
                startActivity(new Intent(DialogDemoActivity.this, SoftwareManagementActivitys.class));
                break;
            case R.id.toolbar_ESDCount:
                startActivity(new Intent(DialogDemoActivity.this, ExternalStorageDirectoryCountUtils.class));
                break;
            case R.id.btn_Web:
                startActivity(new Intent(DialogDemoActivity.this, WebsActivity.class));
                break;
            case R.id.btn_Pager:
                startActivity(new Intent(DialogDemoActivity.this, ViewPagerActivity.class));
                break;
            case R.id.btn_mediaPlay:
                startActivity(new Intent(DialogDemoActivity.this, MediaPlayersActivity.class));
                break;
            case R.id.btn_AppShow:
                startActivity(new Intent(DialogDemoActivity.this, AppShowActivity.class));
                break;
            case R.id.btn_AppShow1:
                startActivity(new Intent(DialogDemoActivity.this, AppShowActivity1.class));
                break;
            default:
                break;
        }
    }
}
