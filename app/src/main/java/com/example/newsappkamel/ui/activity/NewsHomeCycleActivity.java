package com.example.newsappkamel.ui.activity;

import android.os.Bundle;

import com.example.newsappkamel.R;
import com.example.newsappkamel.ui.fragment.homeCycle.menuHome.BusinessHomeFragment;
import com.example.newsappkamel.ui.fragment.homeCycle.menuHome.NewsHomeFragment;
import com.example.newsappkamel.ui.fragment.homeCycle.menuHome.SettingsHomeFragment;
import com.example.newsappkamel.ui.fragment.homeCycle.menuHome.SportHomeFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.newsappkamel.utils.HelperMethod.replaceFragment;

public class NewsHomeCycleActivity extends BaseActivity {
    public static final String API_KEY ="0ee2921b9f634985be46a5249cf2390f";
    @BindView(R.id.home_activity_nb)
     ChipNavigationBar homeActivityNb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cycle);
        ButterKnife.bind(this);

        homeActivityNb.setItemSelected(R.id.menu_item_news,true);
        replaceFragment(getSupportFragmentManager(),R.id.home_activity_frame, new NewsHomeFragment());
        setItems(homeActivityNb);

    }
    public  ChipNavigationBar getNavBAr( ){
       return homeActivityNb;
    }
    private void setItems( ChipNavigationBar homeActivityNb){

        homeActivityNb.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.menu_item_news:
                        replaceFragment(getSupportFragmentManager(),R.id.home_activity_frame, new NewsHomeFragment());
                        break;
                    case R.id.menu_item_bussiness:
                        replaceFragment(getSupportFragmentManager(),R.id.home_activity_frame,new BusinessHomeFragment());
                        break;
                    case R.id.menu_item_sprot:
                        replaceFragment(getSupportFragmentManager(),R.id.home_activity_frame,new SportHomeFragment());
                        break;
                    case R.id.menu_item_settings:
                        replaceFragment(getSupportFragmentManager(),R.id.home_activity_frame,new SettingsHomeFragment());
                        break;

                }
            }
        });

    }
}
