package com.padcmyanmar.news.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.LoginUserVO;
import com.padcmyanmar.news.delegates.LoginUserDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aung on 1/14/18.
 */

public class LoginUserViewPod extends RelativeLayout {

    private LoginUserDelegate mDelegate;

    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void bindData(LoginUserVO loginUser) {

    }

    public void setDelegate(LoginUserDelegate loginUserDelegate) {
        mDelegate = loginUserDelegate;
    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(View view) {
        mDelegate.onTapLogout();
    }
}
