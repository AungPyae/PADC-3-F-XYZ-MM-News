package com.padcmyanmar.news.delegates;

/**
 * Created by aung on 1/27/18.
 */

public interface LoginScreenDelegate {

    /**
     * To be able to navigate Register Screen.
     */
    void onTapToRegister();

    void onTapLoginWithGoogle();
}
