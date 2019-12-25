package com.xxm.wanandroid.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xxm.wanandroid.R;
import com.xxm.wanandroid.model.ArticleModel;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private static final String TAG = HomeAdapter.class.getSimpleName();
    private Context mContext;
    private List<ArticleModel.Article> data;

    public HomeAdapter(Context mContext, List<ArticleModel.Article> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rly_item_public, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleModel.Article article = data.get(position);
        holder.tv_date.setText(article.getNiceDate());
        holder.tv_content.setText(article.getTitle());
        holder.tv_public.setText(article.getSuperChapterName());
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date;
        TextView tv_content;
        TextView tv_public;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_date = itemView.findViewById(R.id.tv_date);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_public = itemView.findViewById(R.id.tv_public);
        }
    }
}
