package com.luis.test.kinedu.WsHandler;

import com.luis.test.kinedu.POJO.Response;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface HttpConectionHandler {
    @GET("catalogue/activities")
    Call<Response> getActivities(@HeaderMap Map<String, String> accept, @Query("skill_id") String skillId, @Query("baby_id") String babiId);

    @GET("catalogue/articles")
    Call<Response> getArticles(@HeaderMap Map<String, String> accept, @Query("skill_id") String skillId, @Query("baby_id") String babiId);

    @GET
    Call<Response> getArticleDetail(@HeaderMap Map<String, String> accept, @Url String fullUrl);

}
