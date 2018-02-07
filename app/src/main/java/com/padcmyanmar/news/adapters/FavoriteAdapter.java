package com.padcmyanmar.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.FavoriteVO;
import com.padcmyanmar.news.viewholders.FavoriteUserViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 2/4/18.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteUserViewHolder> {

    private List<FavoriteVO> mFavoriteUsers;

    public FavoriteAdapter() {
        mFavoriteUsers = new ArrayList<>();
    }

    @Override
    public FavoriteUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_user, parent, false);
        return new FavoriteUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoriteUserViewHolder holder, int position) {
        holder.setData(mFavoriteUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mFavoriteUsers.size();
    }

    public void setData(List<FavoriteVO> favoriteList) {
        mFavoriteUsers = favoriteList;
        notifyDataSetChanged();
    }
}
