package com.xxm.wanandroid.model;


import java.util.List;

public class SystemTreeModel extends BaseModel {

    private List<SystemTreeData> data;

    public List<SystemTreeData> getData() {
        return data;
    }

    public void setData(List<SystemTreeData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SystemTreeModel{" +
                "data=" + data +
                '}';
    }
}





