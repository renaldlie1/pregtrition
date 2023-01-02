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
import com.example.pregtrition.model.Nutritions;

import java.util.ArrayList;

public class NutritionsAdapter extends RecyclerView.Adapter<NutritionsAdapter.ViewHolder> {

    ArrayList<Nutritions> listNutritions;

    public NutritionsAdapter(ArrayList<Nutritions> listNutritions){
        this.listNutritions = listNutritions;
    }


    @NonNull
    @Override
    public NutritionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        NutritionsAdapter.ViewHolder holder = new NutritionsAdapter.ViewHolder(inflater.inflate(R.layout.card_nutrition, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionsAdapter.ViewHolder holder, int position) {
        Nutritions nutritions = listNutritions.get(position);
        holder.food_name.setText(nutritions.getFood_name());
        holder.calories.setText(nutritions.getCalories());
        holder.time.setText(nutritions.getTime());
        holder.img_food.setImageResource(R.drawable.ic_baseline_fastfood_24);

    }

    @Override
    public int getItemCount() {
        return listNutritions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView food_name, calories, time;
        public ImageView img_food;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            food_name = itemView.findViewById(R.id.lbl_food_name);
            calories = itemView.findViewById(R.id.lbl_calories);
            time = itemView.findViewById(R.id.lbl_time);
            img_food = itemView.findViewById(R.id.img_food);

        }
    }
}
