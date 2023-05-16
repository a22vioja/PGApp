package com.example.pgapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Bonsai> trees;
    private LayoutInflater layoutInflater;
    private View.OnClickListener onClickListener;

    public MyAdapter(Context context, ArrayList<Bonsai> trees, View.OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.trees = trees;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(trees.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return trees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.name);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(trees.get(getAdapterPosition()));
        }
    }

    public void addData(ArrayList<Bonsai> listOfBonsai){
        this.trees=listOfBonsai;
    }
    public interface OnClickListener {
        void onClick(Bonsai trees);
    }
}

