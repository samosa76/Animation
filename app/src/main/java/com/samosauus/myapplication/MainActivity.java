package com.samosauus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.samosauus.myapplication.Fragment.IntroductionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new IntroductionFragment()).commit();

    }
}
