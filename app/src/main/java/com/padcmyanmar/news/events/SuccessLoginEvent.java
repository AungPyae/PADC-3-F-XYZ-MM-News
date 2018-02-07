package com.padcmyanmar.news.events;

import android.content.Context;

import com.padcmyanmar.news.data.vo.LoginUserVO;

/**
 * Created by aung on 1/21/18.
 */

public class SuccessLoginEvent {

    private LoginUserVO loginUser;
    private Context context;

    public SuccessLoginEvent(LoginUserVO loginUser, Context context) {
        this.loginUser = loginUser;
        this.context = context;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

    public Context getContext() {
        return context;
    }
}
