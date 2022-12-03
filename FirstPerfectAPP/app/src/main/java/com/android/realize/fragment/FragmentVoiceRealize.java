package com.android.realize.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.android.realize.R;
import com.android.realize.unicom.UiLog;

public class FragmentVoiceRealize extends Fragment {
    private static final String TAG = FragmentVoiceRealize.class.getSimpleName();
    private View root;

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
}
