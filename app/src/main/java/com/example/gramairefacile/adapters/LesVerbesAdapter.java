package com.example.gramairefacile.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.LesVerbes;

import java.util.List;

public class LesVerbesAdapter extends RecyclerView.Adapter<LesVerbesAdapter.LesVerbesViewHolder> {

    private Context context;
    private List<LesVerbes> lesVerbes;

    public LesVerbesAdapter(Context context, List<LesVerbes> lesVerbes) {
        this.context = context;
        this.lesVerbes = lesVerbes;
    }

    public void updateList(List<LesVerbes> lesVerbes) {
        this.lesVerbes = lesVerbes;
        notifyDataSetChanged();
    }

    public void addList(List<LesVerbes> lesVerbes) {
        this.lesVerbes.addAll(lesVerbes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LesVerbesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_lesverbes, parent, false);
        LesVerbesViewHolder vh = new LesVerbesViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LesVerbesViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return lesVerbes.size();
    }

    public class LesVerbesViewHolder extends RecyclerView.ViewHolder {

        private ImageView logoVerbes;
        private TextView titleVerbes;

        public LesVerbesViewHolder(View itemView) {
            super(itemView);

            logoVerbes = itemView.findViewById(R.id.img_logo_verbes);
            titleVerbes = itemView.findViewById(R.id.tv_title_verbes);
        }

        public void onBind(final int position) {
            LesVerbes data = lesVerbes.get(position);

            logoVerbes.setImageResource(data.getIcon());
            titleVerbes.setText(data.getTitle());
        }
    }
}

