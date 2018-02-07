package com.padcmyanmar.news.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.MMNewsApp;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.NewsAdapter;
import com.padcmyanmar.news.data.models.NewsModel;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.NewsActionDelegate;
import com.padcmyanmar.news.events.LoadedNewsEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aung on 1/7/18.
 */

public class NewsByCategoryFragment extends Fragment implements NewsActionDelegate {

    @BindView(R.id.rv_news_by_category)
    RecyclerView rvNewsByCategory;

    private NewsAdapter mNewsByCategoryAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_by_category, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        rvNewsByCategory.setLayoutManager(linearLayoutManager);

        mNewsByCategoryAdapter = new NewsAdapter(this);
        rvNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        NewsModel.getObjInstance().loadNews();

        return view;
    }

    @Override
    public void onTapNewsItem(NewsVO tappedItem) {

    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton(NewsVO news) {

    }

    @Override
    public void onTapFavoriteButton() {

    }

    @Override
    public void onTapLikeUsers(NewsVO tappedNews) {

    }

    @Override
    public void onTapCommentUsers(NewsVO tappedNews) {

    }

    @Override
    public void onTapSentToUsers(NewsVO tappedNews) {

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded : " + event.getNewsList().size());
        mNewsByCategoryAdapter.setNews(event.getNewsList());
    }
}
