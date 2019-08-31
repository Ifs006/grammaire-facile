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
import com.example.gramairefacile.database.model.LesArticles;

import java.util.List;

public class LesArticlesAdapter extends RecyclerView.Adapter<LesArticlesAdapter.LesArticlesViewHolder> {

    private Context context;
    private List<LesArticles> lesArticles;

    public LesArticlesAdapter(Context context, List<LesArticles> lesArticles) {
        this.context = context;
        this.lesArticles = lesArticles;
    }

    public void updateList(List<LesArticles> lesArticles) {
        this.lesArticles = lesArticles;
        notifyDataSetChanged();
    }

    public void addList(List<LesArticles> lesArticles) {
        this.lesArticles.addAll(lesArticles);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LesArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_lesarticles, parent, false);
        LesArticlesViewHolder vh = new LesArticlesViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LesArticlesViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return lesArticles.size();
    }

    public class LesArticlesViewHolder extends RecyclerView.ViewHolder {

        private ImageView logoArticles;
        private TextView titleArticles;

        public LesArticlesViewHolder(View itemView) {
            super(itemView);

            logoArticles = itemView.findViewById(R.id.img_logo_articles);
            titleArticles = itemView.findViewById(R.id.tv_title_articles);
        }

        public void onBind(final int position) {
            LesArticles data = lesArticles.get(position);

            logoArticles.setImageResource(data.getIcon());
            titleArticles.setText(data.getTitle());
        }
    }
}
