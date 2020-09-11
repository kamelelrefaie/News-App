package com.example.newsappkamel.ui.fragment.homeCycle.menuHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newsappkamel.R;
import com.example.newsappkamel.ui.activity.NewsHomeCycleActivity;
import com.example.newsappkamel.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.newsappkamel.utils.HelperMethod.replaceFragment;

public class SettingsHomeFragment extends BaseFragment {
    @BindView(R.id.settings_home_fragment_editText)
    EditText settingsHomeFragmentEditText;
    @BindView(R.id.settings_home_fragment_btn)
    Button settingsHomeFragmentBtn;
    Unbinder unbinder;
    public static  String CN="eg";
    public SettingsHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_settings_home, container, false);
        unbinder = ButterKnife.bind(this, inflate);


        return inflate;
    }

    @OnClick(R.id.settings_home_fragment_btn)
    public void onViewClicked() {
        CN=settingsHomeFragmentEditText.getText().toString();
        if(!CN.equals("us") && !CN.equals("eg")){
            Toast.makeText(baseActivity, "Error", Toast.LENGTH_SHORT).show();
            settingsHomeFragmentEditText.setError("Please choose between us or eg");
            settingsHomeFragmentEditText.getText().clear();
        }else{
            replaceFragment(getActivity().getSupportFragmentManager(),R.id.home_activity_frame,new NewsHomeFragment());

        }


    }
}
