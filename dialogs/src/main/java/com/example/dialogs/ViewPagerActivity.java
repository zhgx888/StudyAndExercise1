package com.example.dialogs;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager mVpg;
    PagerTabStrip mTabStrip;
    ArrayList<String> titleContainer = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mVpg = (ViewPager) this.findViewById(R.id.viewpager);
        mVpg.setVisibility(ViewPager.VISIBLE);
        mTabStrip = (PagerTabStrip) findViewById(R.id.pagertitle);
        initTitles();
        ArrayList<View> views = initViews();
        mTabStrip.setTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        mTabStrip.setDrawFullUnderline(false);
        mTabStrip.setTextColor(getResources().getColor(R.color.colorAccent));
        mTabStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.setViews(views);
        mVpg.setAdapter(adapter);
        mVpg.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int arg0) {
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageSelected(int arg0) {
            }
        });
    }

    void initTitles() {
        titleContainer.add("第1个页面");
        titleContainer.add("第2个页面");
        titleContainer.add("第3个页面");
        titleContainer.add("第4个页面");
    }

    ArrayList<View> initViews() {
        ArrayList<View> views = new ArrayList<View>();
        View view =getLayoutInflater().inflate(R.layout.table1,null);
        views.add(view);
        view =getLayoutInflater().inflate(R.layout.table2,null);
        views.add(view);
        view =getLayoutInflater().inflate(R.layout.table3,null);
        views.add(view);
        ImageView imageView =new ImageView(this);
        imageView.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        views.add(imageView);
        return views;
    }
    class ViewPagerAdapter extends PagerAdapter {
        private Context mCtx;
        ArrayList<View> views=new ArrayList<>();
        ViewPagerAdapter(Context context){
            mCtx=context;
        }

        public void setViews(ArrayList<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object)    {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view =views.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleContainer.get(position);
        }
    }
}
