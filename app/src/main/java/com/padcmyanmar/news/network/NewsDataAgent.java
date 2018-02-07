package com.padcmyanmar.news.network;

import android.content.Context;

/**
 * Created by aung on 12/23/17.
 */

public interface NewsDataAgent {

    /**
     * load news from network api.
     */
    void loadNews();

    /**
     * Login user.
     * @param context
     * @param phoneNo
     * @param password
     */
    void loginUser(Context context, String phoneNo, String password);
}
