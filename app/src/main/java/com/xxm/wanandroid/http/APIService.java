package com.xxm.wanandroid.http;

import com.xxm.wanandroid.model.SystemTreeModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

//    @GET("tree/json")
//    Call<ResponseBody> systemTree();

    @GET("tree/json")
    Observable<SystemTreeModel> systemTree();
}
