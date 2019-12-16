package com.xxm.wanandroid.model;

import java.util.List;

public class SystemTreeChild {

    private int courseId;
    private int id;
    private int order;
    private int parentChapterId;
    private int visible;
    private boolean userControlSetTop;
    private String name;
    private List children;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SystemTreeChild{" +
                "courseId=" + courseId +
                ", id=" + id +
                ", order=" + order +
                ", parentChapterId=" + parentChapterId +
                ", visible=" + visible +
                ", userControlSetTop=" + userControlSetTop +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}