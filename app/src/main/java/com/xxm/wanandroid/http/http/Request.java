package com.xxm.wanandroid.http.http;

import com.xxm.wanandroid.model.ArticleModel;
import com.xxm.wanandroid.model.SystemTreeModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Request {

    String HOST = "https://www.wanandroid.com";


    @GET("tree/json")
    Observable<SystemTreeModel> systemTree();

    @GET("article/list/{pageNum}/json")
    Observable<ArticleModel> homeTree(@Path("pageNum") int pageNum);

    /**
     * 公众号标题
     */
    @GET("wxarticle/chapters/json")
    Observable<SystemTreeModel> wxList();

}