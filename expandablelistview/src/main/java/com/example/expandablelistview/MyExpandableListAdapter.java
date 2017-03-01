package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    Context context;//上下文
    LayoutInflater inflater;//声明一个布局管理器对象
    List<Map<String, Object>> group;//生命一个组集合
    List<List<Map<String, Object>>> child;//声明一个子元素集合
    Map<String, Object> map;//声明一个map对象

    /**
     * 自定义适配器的构造函数
     *
     * @param context 上下文
     * @param group   组集合
     * @param child   子元素集合
     */
    public MyExpandableListAdapter(Context context, List<Map<String, Object>> group, List<List<Map<String, Object>>> child) {
        this.context = context;//初始化上下文
        inflater = LayoutInflater.from(context);//初始化布局管理器对象
        this.child = child;//初始化子元素集合
    }

    /**
     * ExpandableListAdapter里面的所有条目
     * 都可用吗？如果是yes，就意味着所有条目可以选择和点击了。
     * 返回值：返回True表示所有条目均可用。
     */
    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    /**
     * 获取指定组中的指定子元素数据。
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        /**child.get(groupPosition)是得到groupPosition处的list对象，然后
         * child.get(groupPosition).get(childPosition)得到child的map对象，然后
         * child.get(groupPosition).get(childPosition).get("Child")是得到key值
         * 为Child的值
         */
        return child.get(groupPosition).get(childPosition).get("Child");
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    /**
     * 获取指定组中的指定子元素ID，这个ID在组里一定是唯一的。联合ID（getCombinedChildId(long, long)）在所有条目（所有组和所有元素）中也是唯一的。
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        /******子元素的位置********/
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    /**获取一个视图对象，显示指定组中的指定子元素数据。
     * @param groupPosition 组位置（该组内部含有子元素）
     * @param childPosition 子元素位置（决定返回哪个视图）
     * @param isLastChild 子元素是否处于组中的最后一个
     * @param convertView 重用已经有的视图对象，它是RecycleBin缓存机制调用getScrapView方法获取废弃已缓存的view.
     * @param parent 返回的视图(View)对象始终依附于的视图组。通俗的说是它的父视图。
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
