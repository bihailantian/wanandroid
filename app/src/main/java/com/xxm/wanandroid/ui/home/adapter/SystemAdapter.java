package com.xxm.wanandroid.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xxm.wanandroid.R;
import com.xxm.wanandroid.model.SystemTreeChild;
import com.xxm.wanandroid.model.SystemTreeData;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;

public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.ViewHolder> {

    private Context mContext;
    private List<SystemTreeData> data;

    public SystemAdapter(Context mContext, List<SystemTreeData> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rly_item_system, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SystemTreeData systemTreeData = data.get(position);
        holder.tv_title.setText(systemTreeData.getName());
        List<String> tagList = new ArrayList<>();
        List<SystemTreeChild> children = systemTreeData.getChildren();
        if (children != null) {
            for (SystemTreeChild systemTreeChild : children) {
                tagList.add(systemTreeChild.getName());
            }
        }

        holder.tag_view.setTags(tagList);

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title;
        TagContainerLayout tag_view;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tag_view = itemView.findViewById(R.id.tag_view);
        }
    }
}
