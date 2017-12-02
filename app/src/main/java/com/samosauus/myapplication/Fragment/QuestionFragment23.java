package com.samosauus.myapplication.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.samosauus.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment23 extends Fragment {

    Button BacktoQF22,btnyes23,btnno23,btnmaybe23;
    TextView question23;
    String yes,no,maybe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_qustion23, container, false);

        BacktoQF22 = (Button)v.findViewById(R.id.backtoQF22);
        btnyes23 = (Button)v.findViewById(R.id.btnyes23);
        btnno23 = (Button)v.findViewById(R.id.btnyes23);
        btnmaybe23 = (Button)v.findViewById(R.id.btnmaybe23);
        question23 = (TextView)v.findViewById(R.id.question23);

        return v;
    }

}
