package com.example.newsappkamel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsappkamel.R;
import com.example.newsappkamel.data.model.Article;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.newsappkamel.utils.HelperMethod.onLoadImageFromUrl;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    private Context context;
    private ArrayList<Article> newsList = new ArrayList<>();
    private int shimmerNumber =9;
    public boolean isShimmer =true;


    public NewsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        if(isShimmer){
            holder.newsItemShimmer.startShimmer();
        }else {
            holder.newsItemShimmer.stopShimmer();
            holder.newsItemShimmer.setShimmer(null);
            holder.newsItemTxtTitle.setText(newsList.get(position).getTitle());
            holder.newsItemTxtBody.setText(newsList.get(position).getDescription());
            onLoadImageFromUrl(holder.newsItemImg, newsList.get(position).getUrlToImage(), context);
        }
    }

    @Override
    public int getItemCount() {
        return isShimmer?shimmerNumber:newsList.size();
    }

    public void setList(ArrayList<Article> list) {
        this.newsList = list;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_item_img)
        ImageView newsItemImg;
        @BindView(R.id.news_item_txt_title)
        TextView newsItemTxtTitle;
        @BindView(R.id.news_item_txt_body)
        TextView newsItemTxtBody;
        @BindView(R.id.news_item_shimmer)
        ShimmerFrameLayout newsItemShimmer;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
