package com.android.realize.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.android.realize.R;
import com.android.realize.broadcast.StaticRegistrationBroadcast;
import com.android.realize.interfacces.IGeneralInterface;
import com.android.realize.unicom.UiLog;

public class FragmentModuleRealize extends Fragment implements IGeneralInterface {
    private static final String TAG = FragmentModuleRealize.class.getSimpleName();
    private View root;
    private OnClick mOnClick;
    private Button mStaticRegisterBroadcast;

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
        mStaticRegisterBroadcast = root.findViewById(R.id.fragment_module_btn_broadcast_static_register);
        mStaticRegisterBroadcast.setOnClickListener(mOnClick);
    }

    @Override
    public void release() {
        mOnClick = null;
        mStaticRegisterBroadcast = null;
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            UiLog.d(TAG, "OnClick: " + v.getId());
            switch (v.getId()) {
                case R.id.fragment_module_btn_broadcast_static_register: {
                    Intent intent = new Intent();
                    ComponentName componentName = new ComponentName("com.android.realize",
                            "com.android.realize.broadcast.StaticRegistrationBroadcast");
                    intent.setComponent(componentName);
                    getActivity().sendBroadcast(intent);
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
