package com.kg.marat_uulu_daniyar_2of3month;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private TextView textView;
    private Button btn_inc, btn_dec, btn_send;
    static final String KEY_FOR_TEXT = "u";
    Integer num;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private void initView() {
        textView = requireActivity().findViewById(R.id.textView);
        btn_inc = requireActivity().findViewById(R.id.btn_increment);
        btn_dec = requireActivity().findViewById(R.id.btn_decrement);
        btn_send = requireActivity().findViewById(R.id.btn_send);
    }

    @SuppressLint("SetTextI18n")
    private void initListener() {
        btn_inc.setOnClickListener(view -> {
            num = Integer.parseInt(textView.getText().toString());
            num++;
            textView.setText(num.toString());
        });
        btn_dec.setOnClickListener(view -> {
            num = Integer.parseInt(textView.getText().toString());
            num--;
            textView.setText(num.toString());
        });
        btn_send.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_FOR_TEXT, textView.getText().toString());
            ResultFragment resultFragment = new ResultFragment();
            resultFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, resultFragment).addToBackStack(null).commit();
        });
    }

}