package com.samosauus.myapplication.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.samosauus.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment42 extends Fragment {

    Button BacktoQF32,btnyes42,btnno42,btnmaybe42;
    TextView question42;
    String yes,no,maybe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question42, container, false);

        BacktoQF32 = (Button)v.findViewById(R.id.backtoQF32);
        btnyes42 = (Button)v.findViewById(R.id.btnyes42);
        btnmaybe42= (Button)v.findViewById(R.id.btnmaybe42);
        btnno42 = (Button)v.findViewById(R.id.btnno42);

        question42 = (TextView) v.findViewById(R.id.question42);

        Bundle bundle = getArguments();

        question42.setText(String.valueOf(bundle.getString("no")));

        setAnim();

        BacktoQF32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonBackClick();
            }
        });

        btnno42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonNo();
            }
        });

        return v;
    }

    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_fade_in);
        question42.setAnimation(animation_card_in);
        btnyes42.setAnimation(animation_fade_in);
        btnno42.setAnimation(animation_fade_in);
        btnmaybe42.setAnimation(animation_fade_in);

    }

    public void setOnButtonBackClick(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
        }
    }

    public void setOnButtonNo(){

        Fragment Hasil2 = new FragmentHasil2();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame,Hasil2);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
