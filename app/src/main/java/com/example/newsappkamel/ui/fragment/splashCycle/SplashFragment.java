package com.example.newsappkamel.ui.fragment.splashCycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsappkamel.R;
import com.example.newsappkamel.ui.activity.BaseActivity;
import com.example.newsappkamel.ui.activity.NewsHomeCycleActivity;
import com.example.newsappkamel.ui.fragment.BaseFragment;

public class SplashFragment extends BaseFragment {

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_splash, container, false);
     new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {

         getActivity().startActivity(new Intent(getActivity(), NewsHomeCycleActivity.class));
         getActivity().finish();
         }
     },3000);




        return inflate;
    }

    @Override
    public void onBack() {
        getActivity().finish();
    }
}
