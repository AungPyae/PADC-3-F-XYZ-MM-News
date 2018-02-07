package com.padcmyanmar.news.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.models.LoginUserModel;
import com.padcmyanmar.news.delegates.BeforeLoginDelegate;
import com.padcmyanmar.news.delegates.LoginUserDelegate;
import com.padcmyanmar.news.events.SuccessLoginEvent;
import com.padcmyanmar.news.events.UserLogoutEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aung on 1/21/18.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_before_login)
    BeforeLoginViewPod vpBeforeLogin;

    @BindView(R.id.vp_login_user)
    LoginUserViewPod vpLoginUser;

    private LoginUserDelegate mLoginUserDelegate;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        refreshUserSession();

        EventBus.getDefault().register(this);
    }

    public void setDelegate(BeforeLoginDelegate beforeLoginDelegate) {
        vpBeforeLogin.setDelegate(beforeLoginDelegate);
    }

    public void setDelegate(LoginUserDelegate loginUserDelegate) {
        vpLoginUser.setDelegate(loginUserDelegate);
        mLoginUserDelegate = loginUserDelegate;
    }

    private void refreshUserSession() {
        if (LoginUserModel.getObjInstance(getContext()).isUserLogin()) {
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginUser.setVisibility(View.VISIBLE);
        } else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpLoginUser.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.vp_login_user)
    public void onTapLoginUser(View view) {
        mLoginUserDelegate.onTapLoginUser();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginUser.setVisibility(View.VISIBLE);

        vpLoginUser.bindData(event.getLoginUser());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event) {
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginUser.setVisibility(View.GONE);
    }
}
