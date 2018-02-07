package com.padcmyanmar.news.data.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.padcmyanmar.news.data.vo.LoginUserVO;
import com.padcmyanmar.news.events.SuccessLoginEvent;
import com.padcmyanmar.news.events.UserLogoutEvent;
import com.padcmyanmar.news.network.NewsDataAgent;
import com.padcmyanmar.news.network.RetrofitDataAgent;
import com.padcmyanmar.news.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by aung on 1/20/18.
 */

public class LoginUserModel {

    private static LoginUserModel objInstance;

    private NewsDataAgent mDataAgent;

    private LoginUserVO mLoginUser;

    private LoginUserModel(Context context) {
        mDataAgent = RetrofitDataAgent.getObjInstance();
        EventBus.getDefault().register(this);

        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstants.LOGIN_USER_DATA_SP,
                Context.MODE_PRIVATE);
        int loginUserId = sharedPreferences.getInt(AppConstants.LOGIN_USER_ID_KEY, -1);
        if (loginUserId != -1) {
            //user has already logged in.
            String name = sharedPreferences.getString(AppConstants.LOGIN_NAME_KEY, null);

            mLoginUser = new LoginUserVO(loginUserId, name, "", "", "", "");
        }
    }

    public static LoginUserModel getObjInstance(Context context) {
        if (objInstance == null) {
            objInstance = new LoginUserModel(context);
        }
        return objInstance;
    }

    public void loginUser(Context context, String phoneNo, String password) {
        mDataAgent.loginUser(context, phoneNo, password);
    }

    public boolean isUserLogin() {
        return mLoginUser != null;
    }

    public void logout() {
        mLoginUser = null;
        UserLogoutEvent event = new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        mLoginUser = event.getLoginUser();
        //Save user data in SharedPreferences.
        SharedPreferences sharedPreferences =
                event.getContext().getSharedPreferences(AppConstants.LOGIN_USER_DATA_SP,
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(AppConstants.LOGIN_USER_ID_KEY, event.getLoginUser().getUserId());
        editor.putString(AppConstants.LOGIN_NAME_KEY, event.getLoginUser().getName());
        editor.putString("login-email", event.getLoginUser().getEmail());
        editor.putString("login-phone-no", event.getLoginUser().getPhoneNo());
        editor.putString("login-profile-url", event.getLoginUser().getProfileUrl());
        editor.putString("login-cover-url", event.getLoginUser().getCoverUrl());
        editor.apply();
    }

    public LoginUserVO getLoginUser() {
        return mLoginUser;
    }
}
