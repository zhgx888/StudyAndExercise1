package com.example.adapters.provider;

import android.content.Context;

import com.example.adapters.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/25 0025.
 */

public class ProductsBusines {
    public ArrayList<Products> getProduct(Context context) {
        ArrayList<Products> productss = new ArrayList<Products>();
        for (int i = 0; i < 5; i++) {
            Products products = new Products();
            products.title = "美国高端婚纱影楼";
            products.desc = "造型写真，（证件照···）造型写真，(证件照···)";
            products.icon = context.getResources().getDrawable(R.mipmap.ic_launcher);//通过context对象将一个资源id转换成Drawable对象。
            products.url = "http://www.baidu.com";
            productss.add(products);
        }
        return productss;
    }
}