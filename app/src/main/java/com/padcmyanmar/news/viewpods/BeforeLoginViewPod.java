package com.padcmyanmar.news.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.BeforeLoginDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aung on 1/20/18.
 */

public class BeforeLoginViewPod extends RelativeLayout {

    private BeforeLoginDelegate mDelegate;

    public BeforeLoginViewPod(Context context) {
        super(context);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setDelegate(BeforeLoginDelegate delegate) {
        mDelegate = delegate;
    }

    @OnClick(R.id.btn_to_login)
    public void onTapToLogin(View view) {
        mDelegate.onTapToLogin();
    }

    @OnClick(R.id.btn_to_register)
    public void onTapToRegister(View view) {
        mDelegate.onTapToRegister();
    }
}
