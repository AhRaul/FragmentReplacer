package com.example.fragmentreplacer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment2  extends Fragment {

    TextView textMsg;
    final static String KEY_MSG_2 = "FRAGMENT2_MSG";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment2_fragment, null);
        textMsg = (TextView) view.findViewById(R.id.tvMessage);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String msg = bundle.getString(KEY_MSG_2);
            if (msg != null) {
                textMsg.setText(msg);
            }
        }
        return view;
    }

    public void setMsg(String msg) {
        textMsg.setText(msg);
    }

}
