package com.example.newsappkamel.ui.activity;


import androidx.appcompat.app.AppCompatActivity;

import com.example.newsappkamel.ui.fragment.BaseFragment;

public class BaseActivity extends AppCompatActivity {

    public BaseFragment baseFragment;

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }

    public void superBackPressed() {
        super.onBackPressed();
    }

}
