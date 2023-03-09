package com.android.realize.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.android.realize.R;
import com.android.realize.activity.scrollview.ScrollViewActivity;
import com.android.realize.broadcast.BroadcastRegister;
import com.android.realize.activity.carema.CaremaActivity;
import com.android.realize.interfacces.IGeneralInterface;
import com.android.realize.unicom.UiLog;

public class FragmentModuleRealize extends Fragment implements IGeneralInterface {
    private static final String TAG = "FragmentModuleRealize";
    private View root;
    private OnClick mOnClick;
    // 注册广播过滤器
    private IntentFilter mIntentFilter;
    // 静态广播
    private Button mStaticRegisterBroadcast;
    // 动态广播
    private Button mRegisterBroadcast;
    // 相机
    private Button mCarema;
    // 滚动视图
    private Button mScrollView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        UiLog.i(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UiLog.i(TAG, "onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        UiLog.i(TAG, "onCreateView: ");
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_module, container, false);
        }
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        UiLog.i(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        UiLog.i(TAG, "onStart: ");
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
        UiLog.i(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        UiLog.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        UiLog.i(TAG, "onStop: ");
        release();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        UiLog.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        UiLog.i(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        UiLog.i(TAG, "onDetach: ");
    }

    @Override
    public void init() {
        mOnClick = new OnClick();
        mIntentFilter = new IntentFilter();

        mStaticRegisterBroadcast = root.findViewById(R.id.fragment_module_btn_broadcast_static_register);
        mRegisterBroadcast = root.findViewById(R.id.fragment_module_btn_broadcast_register);
        mCarema = root.findViewById(R.id.fragment_module_btn_camera);
        mScrollView = root.findViewById(R.id.fragment_module_btn_scrollView);

        mStaticRegisterBroadcast.setOnClickListener(mOnClick);
        mRegisterBroadcast.setOnClickListener(mOnClick);
        mCarema.setOnClickListener(mOnClick);
        mScrollView.setOnClickListener(mOnClick);
    }

    @Override
    public void release() {
        mOnClick = null;
        mStaticRegisterBroadcast = null;
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fragment_module_btn_broadcast_static_register: {
                    Intent intent = new Intent();
                    ComponentName componentName = new ComponentName("com.android.realize",
                            "com.android.realize.broadcast.StaticRegistrationBroadcast");
                    intent.setComponent(componentName);
                    getActivity().sendBroadcast(intent);
                    break;
                }
                case R.id.fragment_module_btn_broadcast_register: {
                    // 动态注册广播
                    mIntentFilter.addAction("com.android.realize.broadcast.BroadcastRegister");
                    BroadcastRegister broadcastRegister = new BroadcastRegister();
                    getActivity().registerReceiver(broadcastRegister, mIntentFilter);
                    // 发送广播
                    Intent intent = new Intent("com.android.realize.broadcast.BroadcastRegister");
                    getActivity().sendBroadcast(intent);
                    break;
                }
                case R.id.fragment_module_btn_camera: {
                    Intent intent = new Intent(getActivity(), CaremaActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.fragment_module_btn_scrollView: {
                    Intent intent = new Intent(getActivity(), ScrollViewActivity.class);
                    startActivity(intent);
                    break;
                }
                default: {
                    UiLog.w(TAG, "event error");
                    break;
                }
            }
        }
    }
}
