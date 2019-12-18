package com.xxm.wanandroid.ui.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xxm.wanandroid.R;
import com.xxm.wanandroid.model.SystemTreeChild;
import com.xxm.wanandroid.model.SystemTreeData;
import com.xxm.wanandroid.utils.CommonsUtils;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;

public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.ViewHolder> {

    private static final String TAG = SystemAdapter.class.getSimpleName();
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
        List<int[]> colors = new ArrayList<>();
        if (children != null) {
            for (SystemTreeChild systemTreeChild : children) {
                int color = CommonsUtils.getChipBgColor(systemTreeChild.getName());
                Log.d(TAG, "color=" + color);
                //int[] color = {TagBackgroundColor, TabBorderColor, TagTextColor, TagSelectedBackgroundColor}
                int[] color1 = {color, color, Color.BLACK, color};
                colors.add(color1);
                tagList.add(systemTreeChild.getName());
            }
        }

        holder.tag_view.setTags(tagList, colors);

    }


    /**
     * 得到中文首字母（中国 -> ZG）
     *
     * @param str 需要转化的中文字符串
     * @return 大写首字母缩写的字符串
     */
    public static String getPinYinHeadChar(String str) {
        StringBuilder convert = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString().toUpperCase();
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
