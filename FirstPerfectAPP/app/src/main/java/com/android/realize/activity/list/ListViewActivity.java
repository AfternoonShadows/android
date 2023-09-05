package com.android.realize.activity.list;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.activity.list.adapter.ListViewAdapter;
import com.android.realize.activity.list.bean.Browse;
import com.android.realize.interfacces.IGeneralInterface;
import com.android.realize.unicom.UiLog;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements IGeneralInterface {
    private static final String TAG = "ListViewActivity";
    private ListView listView1;
    private ListView listView2;
    private ListView listView3;
    private List<Browse> mBrowses;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        init();
    }

    @Override
    public void init() {
        listView1 = findViewById(R.id.list_view1);
        listView2 = findViewById(R.id.list_view2);
        listView3 = findViewById(R.id.list_view3);
        mBrowses = new ArrayList<>();
    }

    @Override
    public void release() {
        listView1 = null;
        listView2 = null;
        listView3 = null;
        mBrowses.clear();
        mBrowses = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBrowses.add(new Browse("red"));
        mBrowses.add(new Browse("blue"));
        mBrowses.add(new Browse("yellow"));
        ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), mBrowses);
        listView1.setAdapter(listViewAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UiLog.i(TAG, "onStart: position = " + position);
            }
        });
    }
}
