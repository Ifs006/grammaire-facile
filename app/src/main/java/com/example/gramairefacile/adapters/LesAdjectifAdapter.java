package com.example.gramairefacile.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.model.LesAdjectif;

import java.util.List;

public class LesAdjectifAdapter extends RecyclerView.Adapter<LesAdjectifAdapter.LesAdjectifViewHolder> {

    private Context context;
    private List<LesAdjectif> lesAdjectif;

    public LesAdjectifAdapter(Context context, List<LesAdjectif> lesAdjectif) {
        this.context = context;
        this.lesAdjectif = lesAdjectif;
    }

    public void updateList(List<LesAdjectif> lesAdjectif) {
        this.lesAdjectif = lesAdjectif;
        notifyDataSetChanged();
    }

    public void addList(List<LesAdjectif> lesAdjectif) {
        this.lesAdjectif.addAll(lesAdjectif);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LesAdjectifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_lesadjectif, parent, false);
        LesAdjectifViewHolder vh = new LesAdjectifViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LesAdjectifViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return lesAdjectif.size();
    }

    public class LesAdjectifViewHolder extends RecyclerView.ViewHolder {

        private ImageView logoAdjectif;
        private TextView titleAdjectif;

        public LesAdjectifViewHolder(View itemView) {
            super(itemView);

            logoAdjectif = itemView.findViewById(R.id.img_logo_adjectif);
            titleAdjectif = itemView.findViewById(R.id.tv_title_adjectif);
        }

        public void onBind(final int position) {
            LesAdjectif data = lesAdjectif.get(position);

            logoAdjectif.setImageResource(data.getIcon());
            titleAdjectif.setText(data.getTitle());
        }
    }
}
