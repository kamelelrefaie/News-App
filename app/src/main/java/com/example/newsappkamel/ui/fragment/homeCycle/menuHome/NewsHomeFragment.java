package com.example.newsappkamel.ui.fragment.homeCycle.menuHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsappkamel.R;
import com.example.newsappkamel.adapter.NewsAdapter;
import com.example.newsappkamel.data.model.Article;
import com.example.newsappkamel.data.model.GeneralRequest;
import com.example.newsappkamel.ui.fragment.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.newsappkamel.data.api.RetrofitClient.getClient;

public class NewsHomeFragment extends BaseFragment {
    @BindView(R.id.news_home_fragment_rv)
    RecyclerView newsHomeFragmentRv;
    Unbinder unbinder;
    public NewsHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_news_home, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        NewsAdapter adapter = new NewsAdapter(getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        excuteConnection(adapter,layoutManager);


        return inflate;
    }


    private void excuteConnection(NewsAdapter adapter, RecyclerView.LayoutManager layoutManager){
        getClient().getNews(SettingsHomeFragment.CN,"0ee2921b9f634985be46a5249cf2390f").enqueue(new Callback<GeneralRequest>() {
            @Override
            public void onResponse(Call<GeneralRequest> call, Response<GeneralRequest> response) {
                try {
                    if(response.body().getStatus().equals("ok")){
                        adapter.setList((ArrayList<Article>) response.body().getArticles());
                        newsHomeFragmentRv.setAdapter(adapter);
                        newsHomeFragmentRv.setLayoutManager(layoutManager);
                    }else{
                        Toast.makeText(baseActivity, "wrong from server"+response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<GeneralRequest> call, Throwable t) {

            }
        });
    }
}
