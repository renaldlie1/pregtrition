package com.example.pregtrition.view.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pregtrition.APIClient.APIClient;
import com.example.pregtrition.APIClient.NewsInterface;
import com.example.pregtrition.R;
import com.example.pregtrition.adapter.NewsAdapter;
import com.example.pregtrition.model.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearnMoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearnMoreFragment extends Fragment {


    NewsInterface newsInterface;
    RecyclerView recNews;
    NewsAdapter adapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearnMoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearnMoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearnMoreFragment newInstance(String param1, String param2) {
        LearnMoreFragment fragment = new LearnMoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        newsInterface = APIClient.getClient().create(NewsInterface.class);
        getAllNews();




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main_menu, container, false);

        recNews = view.findViewById(R.id.rv_news);

        recNews.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }
    private void getAllNews(){
        Call<List<News>> getNews = newsInterface.getNews();
        getNews.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                ArrayList<News> listNews = (ArrayList<News>) response.body();
                Log.d("list_news: ", response.raw().body().toString());
                Log.d("list_news: ", listNews.toString());

                adapter = new NewsAdapter(listNews);
                recNews.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Log.d("error_news: ", t.getMessage());
            }
        });
    }
}