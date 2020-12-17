package com.example.a12172.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.a12172.R;
import com.example.a12172.bean.MainBean;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {
    private ArrayList<MainBean.ResultsDTO> list;
    private Context context;

    public MainAdapter(ArrayList<MainBean.ResultsDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.list_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Holder holder1=holder;
        Glide.with(context).load(list.get(position).getUrl()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
        }
    }
}
