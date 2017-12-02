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
public class QuestionFragment4 extends Fragment {

    Button BacktoQF3,btnyes4,btnno4,btnmaybe4;
    TextView question4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_question4, container, false);

        BacktoQF3 = (Button)v.findViewById(R.id.backtoQF3);
        btnyes4 = (Button)v.findViewById(R.id.btnyes4);
        btnno4 = (Button)v.findViewById(R.id.btnno4);
        btnmaybe4 = (Button)v.findViewById(R.id.btnmaybe4);
        question4 = (TextView)v.findViewById(R.id.question4);

        Bundle bundle = getArguments();

        question4.setText(String.valueOf(bundle.getString("yes")));

        setAnim();

        BacktoQF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            setOnButtonBackClick();
            }
        });

        btnyes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonYesClick();

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

        Fragment Fragmenthasil = new FragmentHasil();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame,Fragmenthasil);
        transaction.commit();

    }

    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_fade_in);
        question4.setAnimation(animation_card_in);
        btnyes4.setAnimation(animation_fade_in);
        btnno4.setAnimation(animation_fade_in);
        btnmaybe4.setAnimation(animation_fade_in);

    }

}
