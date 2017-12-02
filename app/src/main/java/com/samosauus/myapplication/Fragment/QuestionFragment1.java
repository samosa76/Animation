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
public class QuestionFragment1 extends Fragment {

    Button BacktoIF2,btnyes1,btnno1,btnmaybe1;
    TextView question1;
    String yes,no,maybe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_question1, container, false);

        BacktoIF2 = (Button)v.findViewById(R.id.BacktoIF2);
        btnyes1 = (Button)v.findViewById(R.id.btnyes1);
        btnno1 = (Button)v.findViewById(R.id.btnno1);
        btnmaybe1 = (Button)v.findViewById(R.id.btnmaybe1);
        question1 = (TextView)v.findViewById(R.id.question1);

        setAnim();

        Bundle bundle = getArguments();

        question1.setText("Hallo "+String.valueOf(bundle.getString("nama"))+", Apakah kamu merasa sedang sakit");

        yes = "Apakah sakit yang anda rasakan berada di kepala anda ";
        no = "Apakah anda mempunyai ganguan dalam kejiwaan anda ";
        maybe = "Apakah anda merasa nda kurang sehat";

        BacktoIF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonBackClick();
            }
        });

        btnyes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonYesClick();
            }
        });

        btnno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonNoClick();
            }
        });

        btnmaybe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonMaybe();
            }
        });


        return v;
    }
    public void setOnButtonBackClick(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
        }
    }

    public void setOnButtonYesClick(){

        Fragment Question2 = new QuestionFragment2();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("yes",yes);
        Question2.setArguments(bundle);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame,Question2);
        transaction.commit();

    }

    public void setOnButtonNoClick(){

        Fragment Question22 = new QuestionFragment22();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("no",no);
        Question22.setArguments(bundle);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame,Question22);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void setOnButtonMaybe(){

        Fragment Question23 = new QuestionFragment23();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("maybe",maybe);
        Question23.setArguments(bundle);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame,Question23);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_fade_in);
        question1.setAnimation(animation_card_in);
        btnyes1.setAnimation(animation_fade_in);
        btnno1.setAnimation(animation_fade_in);
        btnmaybe1.setAnimation(animation_fade_in);

    }

}