package com.padcmyanmar.news.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.padcmyanmar.news.R;

/**
 * Created by aung on 2/4/18.
 */

public class AddCommentDialog extends Dialog {

    public AddCommentDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_add_comment);
        setCancelable(false);
    }
}
