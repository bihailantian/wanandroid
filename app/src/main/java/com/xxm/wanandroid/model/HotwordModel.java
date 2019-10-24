package com.xxm.wanandroid.model;

import java.util.List;

public class HotwordModel extends BaseModel{

   private List<DataListBean> data;

    public List<DataListBean> getData() {
        return data;
    }

    public void setData(List<DataListBean> data) {
        this.data = data;
    }

    class DataListBean {
        String link;
        String name;
        int id;
        int order;
        int visible;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }
    }
}
