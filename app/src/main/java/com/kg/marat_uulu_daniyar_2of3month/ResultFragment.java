package com.kg.marat_uulu_daniyar_2of3month;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {
    private TextView textView;
    String result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        textView.setText("Ваше число: " + result);
    }

    private void initView() {
        textView = requireActivity().findViewById(R.id.tv_result);
        if (getArguments() != null) {
            result = getArguments().getString(MainFragment.KEY_FOR_TEXT);
        }
    }
}