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
public class QuestionFragment32 extends Fragment {

    Button BacktoQF22,btnyes32,btnno32,btnmaybe32;
    TextView question32;
    String yes,no,maybe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question32, container, false);
        BacktoQF22 = (Button)v.findViewById(R.id.backtoQF22);
        btnyes32 = (Button)v.findViewById(R.id.btnyes32);
        btnmaybe32= (Button)v.findViewById(R.id.btnmaybe32);
        btnno32 = (Button)v.findViewById(R.id.btnno32);

        question32 = (TextView) v.findViewById(R.id.question32);

        no = "Apakah anda merasa kurang sehat";

        Bundle bundle = getArguments();

        question32.setText(String.valueOf(bundle.getString("no")));

        setAnim();

        BacktoQF22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonBackClick();
            }
        });

        btnno32.setOnClickListener(new View.OnClickListener() {
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
        question32.setAnimation(animation_card_in);
        btnyes32.setAnimation(animation_fade_in);
        btnno32.setAnimation(animation_fade_in);
        btnmaybe32.setAnimation(animation_fade_in);

    }

    public void setOnButtonBackClick(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
        }
    }

    public void setOnButtonNo(){

        Fragment Question42 = new QuestionFragment42();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("no",no);
        Question42.setArguments(bundle);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame,Question42);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
