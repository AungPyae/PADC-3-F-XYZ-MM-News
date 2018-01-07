package com.padcmyanmar.news.data.models;

import com.padcmyanmar.news.network.NewsDataAgent;
import com.padcmyanmar.news.network.RetrofitDataAgent;

/**
 * Created by aung on 12/23/17.
 */

public class NewsModel {

    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private NewsModel() {
        //mDataAgent = HttpUrlConnectionDataAgent.getObjInstance();
        //mDataAgent = OkHttpDataAgent.getObjInstance();
        mDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static NewsModel getObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * Load news from network api.
     */
    public void loadNews() {
        mDataAgent.loadNews();
    }
}
