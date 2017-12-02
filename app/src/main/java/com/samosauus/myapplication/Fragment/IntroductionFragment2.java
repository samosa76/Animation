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
import android.widget.EditText;
import android.widget.TextView;

import com.samosauus.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroductionFragment2 extends Fragment {

    Button btnSubmitNama,backtoIF;
    EditText edtnama;
    TextView txtnama;
    String edt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_introduction2, container, false);

        btnSubmitNama = (Button)v.findViewById(R.id.btnSubmitNama);
        backtoIF = (Button)v.findViewById(R.id.backtoIF);
        edtnama = (EditText)v.findViewById(R.id.edtnama);
        txtnama = (TextView)v.findViewById(R.id.txtinputnama);

        setAnim();

        backtoIF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnSubmitNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt = edtnama.getText().toString();

                Fragment QuestionFragment1 = new QuestionFragment1();
                FragmentManager fm = getActivity().getSupportFragmentManager();

                Bundle bundle = new Bundle();
                bundle.putString("nama",edt);
                QuestionFragment1.setArguments(bundle);

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frame,QuestionFragment1);
                transaction.commit();
            }
        });

        return v;
    }

    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
        }
    }
    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity(),R.anim.anim_fade_in);
        txtnama.setAnimation(animation_card_in);
        edtnama.setAnimation(animation_card_in);
        btnSubmitNama.setAnimation(animation_fade_in);

    }

}
