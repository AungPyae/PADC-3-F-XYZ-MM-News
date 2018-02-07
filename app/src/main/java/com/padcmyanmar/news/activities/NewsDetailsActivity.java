package com.padcmyanmar.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.ImagesInNewsDetailsAdapter;
import com.padcmyanmar.news.data.models.NewsModel;
import com.padcmyanmar.news.data.vo.NewsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aung on 12/9/17.
 */

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);

        /*
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        */

        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        vpNewsDetailsImages.setAdapter(mImagesInNewsDetailsAdapter);

        String newsId = getIntent().getStringExtra("news_id");
        NewsVO news = NewsModel.getObjInstance().getNewsById(newsId);
        bindData(news);
    }

    private void bindData(NewsVO news) {
        tvNewsDetails.setText(news.getDetails());
    }
}
