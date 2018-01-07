package com.padcmyanmar.news.data.vo;

/**
 * Created by aung on 12/17/17.
 */

public class FavoriteVO {

    private String favoriteId;
    private String favoriteDate;
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
