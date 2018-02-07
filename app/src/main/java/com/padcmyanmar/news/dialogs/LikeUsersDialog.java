package com.padcmyanmar.news.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.FavoriteAdapter;
import com.padcmyanmar.news.data.vo.FavoriteVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aung on 2/4/18.
 */

public class LikeUsersDialog extends Dialog {

    @BindView(R.id.rv_like_users)
    RecyclerView rvLikeUsers;

    private FavoriteAdapter mFavoriteAdapter;

    public LikeUsersDialog(@NonNull Context context, List<FavoriteVO> likeUserList) {
        super(context);
        setContentView(R.layout.dialog_like_users);
        ButterKnife.bind(this, this);
        setCancelable(false);

        mFavoriteAdapter = new FavoriteAdapter();
        mFavoriteAdapter.setData(likeUserList);
        rvLikeUsers.setAdapter(mFavoriteAdapter);
        rvLikeUsers.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.iv_close_dialog)
    public void onTapCloseDialog(View view) {
        dismiss();
    }
}
