package com.example.newsappkamel.ui.fragment.homeCycle.menuHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.newsappkamel.R;
import com.example.newsappkamel.adapter.SpinnerAdapter;
import com.example.newsappkamel.ui.fragment.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.newsappkamel.utils.HelperMethod.replaceFragment;

public class SettingsHomeFragment extends BaseFragment {

    @BindView(R.id.settings_home_fragment_btn)
    Button settingsHomeFragmentBtn;
    Unbinder unbinder;
    public static String CN = "eg";
    @BindView(R.id.settings_home_fragment_sp)
    Spinner settingsHomeFragmentSp;
    private AdapterView.OnItemSelectedListener listener;

    public SettingsHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_settings_home, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getContext());
        settingsHomeFragmentSp.setAdapter(spinnerAdapter);

        setListener();

        return inflate;
    }

    private void setListener() {
        listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    CN = "us";
                    Toast.makeText(baseActivity, R.string.click_confirm, Toast.LENGTH_SHORT).show();

                } else if (i == 2) {
                    CN = "eg";
                    Toast.makeText(baseActivity, R.string.click_confirm, Toast.LENGTH_SHORT).show();
                } else if (i == 0) {
                    //Toast.makeText(baseActivity, R.string.choose_country, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

        settingsHomeFragmentSp.setOnItemSelectedListener(listener);
    }

    @OnClick(R.id.settings_home_fragment_btn)
    public void onViewClicked() {
        if (0 != settingsHomeFragmentSp.getSelectedItemPosition()) {
            replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_activity_frame, new NewsHomeFragment());

        } else {
            Toast.makeText(baseActivity, R.string.choose_country, Toast.LENGTH_SHORT).show();
        }

    }
}
