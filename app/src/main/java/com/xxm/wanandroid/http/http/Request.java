package com.xxm.wanandroid.http.http;

import com.xxm.wanandroid.model.SystemTreeModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Request {

    String HOST = "https://www.wanandroid.com";


    @GET("tree/json")
    Observable<SystemTreeModel> systemTree();

}