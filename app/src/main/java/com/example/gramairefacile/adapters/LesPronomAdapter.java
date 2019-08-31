package com.example.gramairefacile.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.model.LesPronom;

import java.util.List;

public class LesPronomAdapter extends RecyclerView.Adapter<LesPronomAdapter.LesPronomViewHolder> {

    private Context context;
    private List<LesPronom> lesPronom;

    public LesPronomAdapter(Context context, List<LesPronom> lesPronom) {
        this.context = context;
        this.lesPronom = lesPronom;
    }

    public void updateList(List<LesPronom> lesPronom) {
        this.lesPronom = lesPronom;
        notifyDataSetChanged();
    }

    public void addList(List<LesPronom> lesPronom) {
        this.lesPronom.addAll(lesPronom);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LesPronomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_lespronom, parent, false);
        LesPronomViewHolder vh = new LesPronomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LesPronomViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return lesPronom.size();
    }

    public class LesPronomViewHolder extends RecyclerView.ViewHolder {

        private ImageView logoPronom;
        private TextView titlePronom;

        public LesPronomViewHolder(View itemView) {
            super(itemView);

            logoPronom = itemView.findViewById(R.id.img_logo_pronom);
            titlePronom = itemView.findViewById(R.id.tv_title_pronom);
        }

        public void onBind(final int position) {
            LesPronom data = lesPronom.get(position);

            logoPronom.setImageResource(data.getIcon());
            titlePronom.setText(data.getTitle());
        }
    }
}
