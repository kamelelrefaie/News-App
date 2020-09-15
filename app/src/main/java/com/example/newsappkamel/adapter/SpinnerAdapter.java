package com.example.newsappkamel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newsappkamel.R;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflter;
    private ArrayList<String> cnList = new ArrayList<>();



    public SpinnerAdapter(Context applicationContext) {
        this.context = applicationContext;
        inflter = (LayoutInflater.from(applicationContext));

        cnList.add("Choose Country");
        cnList.add("USA");
        cnList.add("Egypt");
    }


    @Override
    public int getCount() {
        return cnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.items_spinner,null);

        TextView names =  view.findViewById(R.id.item_spinner_tv_text);
        names.setText(cnList.get(i));

        return view;
    }
}
