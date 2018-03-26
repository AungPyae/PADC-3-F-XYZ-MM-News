package com.padcmyanmar.news.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by aung on 2/11/18.
 */

public class SampleService2 extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public SampleService2() {
        super("SampleService2");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
