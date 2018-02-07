package com.padcmyanmar.news.delegates;

import com.padcmyanmar.news.data.vo.NewsVO;

/**
 * Created by aung on 12/17/17.
 */

public interface NewsActionDelegate {

    void onTapNewsItem(NewsVO tappedNews);

    void onTapCommentButton();

    void onTapSendToButton(NewsVO tappedNews);

    void onTapFavoriteButton();

    void onTapLikeUsers(NewsVO tappedNews);

    void onTapCommentUsers(NewsVO tappedNews);

    void onTapSentToUsers(NewsVO tappedNews);
}
