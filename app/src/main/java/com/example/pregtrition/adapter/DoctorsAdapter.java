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
import com.example.pregtrition.model.Doctors;
import com.example.pregtrition.model.News;

import java.util.ArrayList;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ViewHolder> {

    ArrayList <Doctors> listDoctors;

    public DoctorsAdapter(ArrayList<Doctors> listDoctors) {
        this.listDoctors = listDoctors;
    }

    @NonNull
    @Override
    public DoctorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        DoctorsAdapter.ViewHolder holder = new DoctorsAdapter.ViewHolder(inflater.inflate(R.layout.card_listdoctor, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsAdapter.ViewHolder holder, int position) {
        Doctors doctors = listDoctors.get(position);

        holder.doctor_name.setText(doctors.getDoctor_name());
        holder.doctor_profesion.setText(doctors.getDoctor_profesion());
        holder.doctor_exp.setText(doctors.getDoctor_exp());
        holder.img_doctor.setImageResource(R.drawable.doctorboy);

//        holder.name.setText(news.getName());
//        holder.nim.setText(news.getNim());
//        holder.prodi.setText(news.getProdi());

    }

    @Override
    public int getItemCount() {
        return listDoctors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView doctor_name, doctor_profesion, doctor_exp;
        public ImageView img_doctor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            doctor_name = itemView.findViewById(R.id.doctor_name);
            doctor_profesion = itemView.findViewById(R.id.doctor_profesion);
            doctor_exp = itemView.findViewById(R.id.doctor_exp);
            img_doctor = itemView.findViewById(R.id.img_poster_card_doctor);
        }
    }
}
