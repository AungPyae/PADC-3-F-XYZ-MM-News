package com.padcmyanmar.news.network;

import com.padcmyanmar.news.network.responses.GetNewsResponse;
import com.padcmyanmar.news.network.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aung on 1/6/18.
 */

public interface NewsApi {

    @FormUrlEncoded
    @POST("v1/getMMNews.php")
    Call<GetNewsResponse> loadNews(@Field("page") int page,
                                   @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("v1/login.php")
    Call<LoginResponse> loginUser(@Field("phoneNo") String phoneNo,
                                  @Field("password") String password);
}
