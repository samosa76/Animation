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
public class QuestionFragment2 extends Fragment {

    TextView question2;
    Button btnno2,btnyes2,btnmaybe2,btnBackToQf;
    String yes,no;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_question2, container, false);

        question2 = (TextView)v.findViewById(R.id.question2);
        btnyes2 = (Button)v.findViewById(R.id.btnyes2);
        btnno2 = (Button)v.findViewById(R.id.btnno2);
        btnmaybe2 = (Button)v.findViewById(R.id.btnmaybe2);
        btnBackToQf = (Button)v.findViewById(R.id.backtoQF);

        yes = "Apakah pusing yang anda rasakan terasa sangat sakit ";
        no = "Apakah anda merasa kelelahan ";

        Bundle bundle = getArguments();

        question2.setText(String.valueOf(bundle.getString("yes")));

        setAnim();

        btnBackToQf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonBackClick();
            }
        });

        btnyes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonYesClick();
            }
        });

        return v;
    }

    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_fade_in);
        question2.setAnimation(animation_card_in);
        btnyes2.setAnimation(animation_fade_in);
        btnno2.setAnimation(animation_fade_in);
        btnmaybe2.setAnimation(animation_fade_in);

    }

    public void setOnButtonBackClick(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
        }
    }
    public void setOnButtonYesClick(){

        Fragment QuestionFragment3 = new QuestionFragment3();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("yes",yes);
        QuestionFragment3.setArguments(bundle);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame,QuestionFragment3);
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
//        bundle.putString("maybe",maybe);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame,Question23);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
