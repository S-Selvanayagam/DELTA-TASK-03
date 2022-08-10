package com.example.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {
    private Context mcontext;
    private List<DataModel> moviesList;

    public Adaptery(Context mcontext, List<DataModel> moviesList) {
        this.mcontext = mcontext;
        this.moviesList=moviesList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        v=layoutInflater.inflate(R.layout.recycler_adapter,parent,false );
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ID.setText(moviesList.get(position).getAuthor());
        holder.Movie.setText(moviesList.get(position).getContent());

    }

    @Override
    public int getItemCount() {

        return moviesList.size();
    }
    public void filterlist(ArrayList<DataModel> filteredlist)
    {
        moviesList=filteredlist;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Movie;
        TextView ID;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Movie=itemView.findViewById(R.id.Movie);
            ID=itemView.findViewById(R.id.ID);
        }
    }

}

