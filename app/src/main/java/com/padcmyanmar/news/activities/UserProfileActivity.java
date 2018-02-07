package com.padcmyanmar.news.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.news.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aung on 2/3/18.
 */

public class UserProfileActivity extends BaseActivity {

    @BindView(R.id.iv_user_profile)
    ImageView ivUserProfile;

    @BindView(R.id.iv_user_cover)
    ImageView ivUserCover;


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, UserProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 234) {
            Uri originalUri = data.getData();
            Glide.with(getApplicationContext())
                    .load(originalUri)
                    .into(ivUserProfile);
        } else if (requestCode == 345) {
            Bundle extras = data.getExtras();
            Bitmap takenPicture = (Bitmap) extras.get("data");
            ivUserCover.setImageBitmap(takenPicture);
        }
    }

    @OnClick(R.id.iv_edit_profile)
    public void onTapEditProfileImage(View view) {
        //Toast.makeText(getApplicationContext(), "Tap Edit Profile", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        startActivityForResult(intent, 234);
    }

    @OnClick(R.id.iv_edit_cover)
    public void onTapEditCoverImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 345);
    }
}
