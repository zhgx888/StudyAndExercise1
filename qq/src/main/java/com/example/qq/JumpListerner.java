package com.example.qq;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class JumpListerner implements View.OnClickListener {
    private Context ctx;
    public JumpListerner(Context context) {
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(ctx,SecondActivity.class);
        ctx.startActivity(intent);
    }
}
