package com.example.adapters.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.R;
import com.example.adapters.provider.Products;
import com.example.adapters.provider.ProductsBusines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/25 0025.
 */

public class CustomAdapterActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView mcustomLV;
    Context mctx;
    ArrayList<Products> mProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mctx=this;
        setContentView(R.layout.activity_listview_adapter);
        mcustomLV = (ListView) findViewById(R.id.list_View);//根据ID找控件
        ProductsBusines pb = new ProductsBusines();
        mProducts = pb.getProduct(mctx);//获取数据用List封装
        mcustomLV.setAdapter(new CustomAdapter());//将适配器给ListView控件
        mcustomLV.setOnItemClickListener(this);
    }

    /**
     * 用户点击某一项，回传些事件，我们重写些方法做相应处理
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Products products = (Products) adapterView.getItemAtPosition(position);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(products.url));
        mctx.startActivity(i);
    }

        class CustomAdapter extends BaseAdapter {
        Map<Integer, String> map = new HashMap<Integer, String>();
        @Override
        public int getCount() {//数据数量
            return mProducts.size();
        }

        @Override
        public Object getItem(int position) {//根据下标获取对应数据position:对应下标
            return mProducts.get(position);
        }

        @Override
        public long getItemId(int position) {//根据下标获取对应数据ID position
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {//生成数据对应布局 position
//          1.复用view优化listview,创建一个view作为getview的返回值用来显示一个条目
            View v = view;
            if (v == null) {
//                mctx:上下文, resource:要转换成view对象的layout的id,
//                root:将layout用root(ViewGroup)包一层作为codify的返回值,一般传null
//                v = View.inflate(mctx, R.layout.item_product_layout, null);
//                通过LayoutInflater将布局转换成view对象
//			      v =  LayoutInflater.from(context).inflate(R.layout.item_news_layout, null);
//                通过context获取系统服务得到一个LayoutInflater，通过LayoutInflater将一个布局转换为view对象
                LayoutInflater layoutInflater = (LayoutInflater) mctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(R.layout.activity_custom_adapter,null);
            }
//            2.获取view上的子控件对象
            ImageView proIcon= (ImageView) v.findViewById(R.id.item_img_icon);
            TextView proTitle= (TextView) v.findViewById(R.id.item_tv_title);
            TextView proDesc= (TextView) v.findViewById(R.id.item_tv_des);
//          3.获取postion位置条目对应的list集合中的数据，Bean对象
            Products products=mProducts.get(position);
//          4.将数据设置给这些子控件做显示
            proIcon.setBackground(products.icon);
            proTitle.setText(products.title);
            proDesc.setText(products.desc);
            return v;
/**
 * 防止运行时会来回滚动一直生成占用内存
 */
//            TextView tv=(TextView) view;
//            if (view==null){
//                tv = new TextView(mctx);
//            }
//                tv.setText("position#############:" + position);
//
//            map.put(tv.hashCode(),"");
//            Log.i(TAG,""+map.size());
//            return tv;
        }
    }
}