package com.padcmyanmar.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.NewsActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aung on 12/3/17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.iv_news)
    ImageView ivNews;

    @BindView(R.id.tv_likes)
    TextView tvLikes;

    @BindView(R.id.tv_comments)
    TextView tvComments;

    @BindView(R.id.tv_sent_tos)
    TextView tvSentTos;

    private NewsActionDelegate mNewsActionDelegate;

    private NewsVO mNews;

    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mNewsActionDelegate = newsActionDelegate;
    }

    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View view) {
        //Toast.makeText(view.getContext(), "News Item Clicked", Toast.LENGTH_LONG).show();
        mNewsActionDelegate.onTapNewsItem(mNews);
    }

    @OnClick(R.id.fl_send_to)
    public void onTapSendTo(View view) {
        mNewsActionDelegate.onTapSendToButton(mNews);
    }

    @OnClick(R.id.tv_likes)
    public void onTapLikeUsers(View view) {
        mNewsActionDelegate.onTapLikeUsers(mNews);
    }

    @OnClick(R.id.tv_comments)
    public void onTapCommentUsers(View view) {
        mNewsActionDelegate.onTapCommentUsers(mNews);
    }

    @OnClick(R.id.tv_sent_tos)
    public void onTapSentToUsers(View view) {
        mNewsActionDelegate.onTapSentToUsers(mNews);
    }

    @OnClick(R.id.fl_comment)
    public void onTapAddComment(View view) {
        mNewsActionDelegate.onTapCommentButton();
    }

    public void setNews(NewsVO news) {
        mNews = news;

        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsBrief.setText(news.getBrief());

        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);

        if (news.getImages() != null) {
            ivNews.setVisibility(View.VISIBLE);
            Glide.with(ivNews.getContext())
                    .load(news.getImages().get(0))
                    .into(ivNews);
        } else {
            ivNews.setVisibility(View.GONE);
        }

        tvLikes.setText(
                tvLikes.getContext().getResources().getString(R.string.format_like_users,
                        news.getFavorites().size()));

        tvComments.setText(
                tvComments.getContext().getResources().getString(R.string.format_comment_users,
                        news.getComments().size()));

        tvSentTos.setText(
                tvSentTos.getContext().getResources().getString(R.string.format_sent_to_users,
                        news.getSentTos().size()));
    }
}
