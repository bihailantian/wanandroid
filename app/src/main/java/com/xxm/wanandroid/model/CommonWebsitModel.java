package com.xxm.wanandroid.model;

import java.util.List;

public class CommonWebsitModel extends BaseModel {

    private List<DataListBean> data;

    public List<DataListBean> getData() {
        return data;
    }

    public void setData(List<DataListBean> data) {
        this.data = data;
    }

    class DataListBean {
        private String icon;
        private String link;
        private String name;
        private int id;
        private int order;
        private int visible;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

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
