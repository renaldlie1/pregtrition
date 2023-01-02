package com.example.pregtrition.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pregtrition.R;
import com.example.pregtrition.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    ArrayList<News> listNews;

    public NewsAdapter(ArrayList<News> listNews){
        this.listNews = listNews;
    }
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.card_news, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news = listNews.get(position);
        holder.name.setText(news.getNews());



    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,nim,prodi ;
        public ImageView img_doctor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img_doctor = itemView.findViewById(R.id.img_poster_card_doctor);
        }
    }
}
