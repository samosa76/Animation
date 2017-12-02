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
public class QuestionFragment3 extends Fragment {

    Button BacktoQF2,btnyes3,btnno3,btnmaybe3;
    TextView question3;
    String yes,no,maybe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question3, container, false);

        BacktoQF2 = (Button)v.findViewById(R.id.backtoQF2);
        btnmaybe3 = (Button)v.findViewById(R.id.btnmaybe3);
        btnyes3 = (Button)v.findViewById(R.id.btnyes3);
        btnno3 = (Button)v.findViewById(R.id.btnno3);
        question3 = (TextView)v.findViewById(R.id.question3);

        yes = "Apakah anda merasa pusing hanya dibagian sebelah kepala anda";

        Bundle bundle = getArguments();

        question3.setText(String.valueOf(bundle.getString("yes")));

        setAnim();

        BacktoQF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonBackClick();
            }
        });

        btnyes3.setOnClickListener(new View.OnClickListener() {
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

        Fragment Question4 = new QuestionFragment4();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("yes",yes);
        Question4.setArguments(bundle);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame,Question4);
        transaction.commit();

    }

    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_fade_in);
        question3.setAnimation(animation_card_in);
        btnyes3.setAnimation(animation_fade_in);
        btnno3.setAnimation(animation_fade_in);
        btnmaybe3.setAnimation(animation_fade_in);

    }

}
