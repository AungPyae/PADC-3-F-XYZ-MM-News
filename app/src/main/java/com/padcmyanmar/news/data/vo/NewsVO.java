package com.padcmyanmar.news.data.vo;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 12/17/17.
 */

public class NewsVO {

    @SerializedName("news-id")
    private String newsId;
    private String brief;
    private String details;
    private List<String> images;

    @SerializedName("posted-date")
    private String postedDate;

    private PublicationVO publication;
    private List<FavoriteVO> favorites;
    private List<CommentVO> comments;

    @SerializedName("sent-tos")
    private List<SentToVO> sentTos;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<String> getImages() {
        return images;
    }

    public List<FavoriteVO> getFavorites() {
        if (favorites == null)
            favorites = new ArrayList<>();
        return favorites;
    }

    public List<CommentVO> getComments() {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        return comments;
    }

    public List<SentToVO> getSentTos() {
        if (sentTos == null)
            sentTos = new ArrayList<>();
        return sentTos;
    }
}
