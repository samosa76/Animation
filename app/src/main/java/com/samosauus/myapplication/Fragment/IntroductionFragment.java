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
public class IntroductionFragment extends Fragment {

    Button btnBerikutnya;
    TextView txtperkenalan;
    String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_introduction, container, false);

        btnBerikutnya = (Button)v.findViewById(R.id.btnSubmitNama);
        txtperkenalan = (TextView)v.findViewById(R.id.txtperkenalan);

        setAnim();

        text = "Hallo, perkenalkan nama saya ada, saya yang akan membantu dalam menyelesaikan masalah yang sedang anda hadapi";

        btnBerikutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntroductionFragment2 myFragment = new IntroductionFragment2();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("data",text);
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.frame,myFragment,"IntroductionFragment");
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        return v;
    }
    public void setAnim(){
        Animation animation_card_in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_card_in);
        Animation animation_fade_in= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.anim_fade_in);
        txtperkenalan.setAnimation(animation_card_in);
        btnBerikutnya.setAnimation(animation_fade_in);

    }

}
