package com.example.pregtrition.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pregtrition.APIClient.APIClient;
import com.example.pregtrition.APIClient.APIInterface;
import com.example.pregtrition.R;
import com.example.pregtrition.adapter.DoctorsAdapter;

import com.example.pregtrition.model.Doctors;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultFragment extends Fragment {

    APIInterface apiInterface;
    RecyclerView recDoctors;
    DoctorsAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConsultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultFragment newInstance(String param1, String param2) {
        ConsultFragment fragment = new ConsultFragment();
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

        apiInterface = APIClient.getClient().create(APIInterface.class);
        getAllDoctors();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_consult, container, false);

        recDoctors = view.findViewById(R.id.rv_doctors);

        recDoctors.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    private void getAllDoctors(){
        Call<List<Doctors>> getDoctors = apiInterface.getDoctors();
        getDoctors.enqueue(new Callback<List<Doctors>>() {
            @Override
            public void onResponse(Call<List<Doctors>> call, Response<List<Doctors>> response) {
                ArrayList<Doctors> listDoctors = (ArrayList<Doctors>) response.body();
                Log.d("list_doctors: ", response.raw().body().toString());
                Log.d("list_doctors: ", listDoctors.toString());

                adapter = new DoctorsAdapter(listDoctors);
                recDoctors.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Doctors>> call, Throwable t) {
                Log.d("error_news: ", t.getMessage());
            }
        });
    }
}