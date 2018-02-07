package com.padcmyanmar.news.data.models;

import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.events.LoadedNewsEvent;
import com.padcmyanmar.news.network.NewsDataAgent;
import com.padcmyanmar.news.network.RetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aung on 12/23/17.
 */

public class NewsModel {

    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private Map<String, NewsVO> mNews;

    private NewsModel() {
        //mDataAgent = HttpUrlConnectionDataAgent.getObjInstance();
        //mDataAgent = OkHttpDataAgent.getObjInstance();
        mDataAgent = RetrofitDataAgent.getObjInstance();
        mNews = new HashMap<>();

        EventBus.getDefault().register(this);
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

    /**
     * Get news object by id.
     *
     * @param newsId
     * @return
     */
    public NewsVO getNewsById(String newsId) {
        return mNews.get(newsId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event) {
        for (NewsVO news : event.getNewsList()) {
            mNews.put(news.getNewsId(), news);
        }
    }
}
