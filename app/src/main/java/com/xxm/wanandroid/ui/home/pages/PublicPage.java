package com.xxm.wanandroid.ui.home.pages;

import android.content.Context;
import android.widget.TextView;

import com.xxm.wanandroid.R;

public class PublicPage extends BasePage {
    TextView text;

    public PublicPage(Context mContext) {
        super(mContext);
    }

    @Override
    protected void initView() {
        super.initView();
        text = mRootPage.findViewById(R.id.text);
    }

    public void setText(String content) {
        if (text != null)
            text.setText(content);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.page_list;
    }
}
