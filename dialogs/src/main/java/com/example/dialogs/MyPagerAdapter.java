package com.example.dialogs;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by Administrator on 2017/1/10 0010.
 */

public class MyPagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
