package com.android.realize.activity.list;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.realize.R;
import com.android.realize.interfacces.IGeneralInterface;

/**
 *
 **/
public class RecyclerViewActivity extends AppCompatActivity implements IGeneralInterface {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        init();
    }


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
