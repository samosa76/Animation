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
public class QuestionFragment22 extends Fragment {

    Button BacktoQF1,btnyes22,btnno22,btnmaybe22;
    TextView question22;
    String yes,no,maybe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question22, container, false);

        BacktoQF1 = (Button)v.findViewById(R.id.backtoQF);
        btnyes22 = (Button)v.findViewById(R.id.btnyes22);
        btnno22 = (Button)v.findViewById(R.id.btnno22);
        btnmaybe22 = (Button)v.findViewById(R.id.btnmaybe22);
        question22 = (TextView)v.findViewById(R.id.question22);

        Bundle bundle = getArguments();

        question22.setText(String.valueOf(bundle.getString("no")));

        setAnim();

        no = "Apakah anda merasa jenuh dengan kegiatan sehari-hari anda ";

        BacktoQF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonBackClick();
            }
        });

        btnno22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnButtonNo();
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

    public void setOnButtonNo(){

        Fragment Question32 = new QuestionFragment32();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("no",no);
        Question32.setArguments(bundle);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame,Question32);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_fade_in);
        question22.setAnimation(animation_card_in);
        btnyes22.setAnimation(animation_fade_in);
        btnno22.setAnimation(animation_fade_in);
        btnmaybe22.setAnimation(animation_fade_in);

    }


}
