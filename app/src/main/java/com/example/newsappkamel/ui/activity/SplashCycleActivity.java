package com.example.newsappkamel.ui.activity;

import android.os.Bundle;

import com.example.newsappkamel.R;
import com.example.newsappkamel.ui.fragment.splashCycle.SplashFragment;

import static com.example.newsappkamel.utils.HelperMethod.replaceFragment;

public class SplashCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_cycle);

        replaceFragment(getSupportFragmentManager(),R.id.frame,new SplashFragment());

    }
}