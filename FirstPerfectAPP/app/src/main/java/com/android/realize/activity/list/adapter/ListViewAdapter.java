package com.android.realize.activity.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.android.realize.R;
import com.android.realize.activity.list.bean.Browse;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Browse> mBrowse;

    public ListViewAdapter(Context applicationContext, List<Browse> list) {
        this.mContext = applicationContext;
        this.mBrowse = list;
    }

    @Override
    public int getCount() {
        return mBrowse.size();
    }

    @Override
    public Browse getItem(int position) {
        return mBrowse.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // 通过适配器获取视图
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_listview_adapterview, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.list_view_text);
        Browse browse = getItem(position);
        textView.setText(browse.getText());
        return convertView;
    }
}
