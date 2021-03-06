package com.xxm.wanandroid.model;

import java.util.List;

/**
 * 文章
 */
public class ArticleModel extends BaseModel {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private int curPage;
        private int offset;
        private int pageCount;
        private int size;
        private int total;
        private boolean over;
        private List<Article> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public List<Article> getDatas() {
            return datas;
        }

        public void setDatas(List<Article> datas) {
            this.datas = datas;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "curPage=" + curPage +
                    ", offset=" + offset +
                    ", pageCount=" + pageCount +
                    ", size=" + size +
                    ", total=" + total +
                    ", over=" + over +
                    ", datas=" + datas +
                    '}';
        }
    }

    public class Article {
        private int chapterId;
        private int courseId;
        private int id;
        private long publishTime;
        private int superChapterId;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private boolean collect;
        private boolean fresh;
        private String apkLink;
        private String author;
        private String chapterName;
        private String desc;
        private String envelopePic;
        private String link;
        private String niceDate;
        private String origin;
        private String projectLink;
        private String superChapterName;
        private String title;
        private List<Tag> tags;

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

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

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "chapterId=" + chapterId +
                    ", courseId=" + courseId +
                    ", id=" + id +
                    ", publishTime=" + publishTime +
                    ", superChapterId=" + superChapterId +
                    ", type=" + type +
                    ", userId=" + userId +
                    ", visible=" + visible +
                    ", zan=" + zan +
                    ", collect=" + collect +
                    ", fresh=" + fresh +
                    ", apkLink='" + apkLink + '\'' +
                    ", author='" + author + '\'' +
                    ", chapterName='" + chapterName + '\'' +
                    ", desc='" + desc + '\'' +
                    ", envelopePic='" + envelopePic + '\'' +
                    ", link='" + link + '\'' +
                    ", niceDate='" + niceDate + '\'' +
                    ", origin='" + origin + '\'' +
                    ", projectLink='" + projectLink + '\'' +
                    ", superChapterName='" + superChapterName + '\'' +
                    ", title='" + title + '\'' +
                    ", tags=" + tags +
                    '}';
        }
    }

    class Tag {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Tag{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "ArticleModel{" +
                "data=" + data +
                '}';
    }
}
