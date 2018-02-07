package com.padcmyanmar.news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 12/17/17.
 */

public class FavoriteVO {

    @SerializedName("favorite-id")
    private String favoriteId;

    @SerializedName("favorite-date")
    private String favoriteDate;

    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    public String getFavoriteId() {
        return favoriteId;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
