package com.example.test_rec_99;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

    private ArrayList<MainModel> mainModels;
    Context context_main;
    private RecyclerViewClickListener listener;

    public MainAdapter(ArrayList<MainModel> mainModels, Context context_main, RecyclerViewClickListener listener) {
        this.mainModels = mainModels;
        this.context_main = context_main;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context_main);
        View view_main = layoutInflater.inflate(R.layout.item_in_main, parent, false);
        return new MainViewHolder(view_main);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        holder.imageView.setImageResource(mainModels.get(position).getImage());
        holder.title.setText(mainModels.get(position).getTitle());
        holder.desc.setText(mainModels.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }



    //////////// INTERFACE
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
    /////////////////////////////


    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView title;
        TextView desc;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());

        }
    }
}
